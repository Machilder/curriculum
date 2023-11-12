package jp.co.sss.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.form.LoginForm;
import jp.co.sss.sys.form.MypageForm;
import jp.co.sss.sys.repository.EmployeeRepository;
//import jp.co.sss.sys.repository.EmployeeService;

/**
 * コントローラークラス このクラスはWebアプリケーションのコントローラーで、ユーザーからのリクエストを処理する。
 * 
 * @author Inoue Nami
 */
@RequestMapping("")
@Controller
public class IndexController {

    @Autowired
    EmployeeRepository employeeRepository;

//    EmployeeService employeeService;
    /**
     * ログイン画面を表示するメソッド
     * 
     * @param loginForm ログインフォームのデータを受け取り
     * @return login.html ログイン画面のテンプレートを返す
     */
    // @RequestMapping(path = "/login", method = RequestMethod.GET)
    @GetMapping(path = "/login")
    public String login(LoginForm loginForm) {
        return "login";
    }

    /**
     * ユーザーが入力した値を使用してログイン認証を行い、トップ画面に遷移するメソッド
     * 
     * @param loginForm ログインフォームのデータを受け取り
     * @param request   HTTPリクエスト情報を受け取り
     * @param response  HTTPレスポンス情報を受け取り
     * @return top.html トップ画面のテンプレートを返し
     */
    // @RequestMapping(path = "/top", method = RequestMethod.POST)
    @PostMapping(path = "/login")
    public String login(@Valid LoginForm loginForm, BindingResult result, Model model, HttpServletRequest request,
            HttpServletResponse response) {

        // バリデーションエラーがあるかどうかを確認
        if (result.hasErrors()) {
            return "login"; // エラーがあればログイン画面に戻る
        }

        try {

            Employee emp = employeeRepository.findByempIdAndPassword(loginForm.getEmpId(), loginForm.getPassword());

            if (emp != null) {
                // 該当データがあればトップ画面に遷移
                List<Employee> emplist = employeeRepository.findAll();
                request.getSession().setAttribute("loggedInUser", emp);
                request.getSession().setAttribute("loginForm", loginForm);
                model.addAttribute("emplist", emplist);
                model.addAttribute("loginForm", loginForm);
                return "top";
            } else {
                // 該当データがなければエラーメッセージを表示
                result.reject("loginError", "社員番号またはパスワードが違います。");
                return "login";
            }

        } catch (NullPointerException e) {
            // エラーが発生した場合はログイン画面に戻る
            return "login";
        }
    }

    /**
     * ログアウト処理を行うメソッド
     * 
     * @param loginForm ログインフォームのデータを受け取ります
     * @return login.html ログイン画面にリダイレクトします
     */
    @GetMapping("/logout")
    public String logout(@ModelAttribute("loginForm") LoginForm loginForm) {

        // フォームのデータをクリア
        loginForm.clear();

        // request.getSession().invalidate();

        // ログイン画面にリダイレクト
        return "redirect:/login";
    }

    @GetMapping("/employeeList")
    public String employeeList(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {

        List<Employee> emplist = employeeRepository.findAll();

        // ログインフォームをセット
        model.addAttribute("loginForm", loginForm);

        // 社員一覧をセット
        model.addAttribute("emplist", emplist);

        // ログイン画面にリダイレクト
        return "/top";
    }

    @GetMapping("/mypage")
    public String mypage(LoginForm loginForm, Model model, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("loggedInUser");
        // Employee emp = (Employee) model.getAttribute("loggedInUser");

         try {
        // MypageFormを生成し、Employee情報を一括で設定
        MypageForm mypageForm = new MypageForm();
        mypageForm.setMypage(emp);

        // ビューに渡す
        model.addAttribute("mypageForm", mypageForm);

        return "mypage";
        } catch (NullPointerException e) {
            // エラーが発生した場合はログイン画面に戻る
            return "login";
        }
    }

    @PostMapping("/mypage/update")
    public String mypageUpdate(@Valid MypageForm mypageForm, BindingResult result, Model model, HttpSession session) {
        try {
            // バリデーションエラーがあるかどうかを確認
            if (result.hasErrors()) {
                return "mypage"; // エラーがあればマイページに戻る
            }

            // セッションからログイン情報を取得
            Employee emp = (Employee) session.getAttribute("loggedInUser");

            // 該当ユーザが存在しない場合はエラー画面に遷移
            if (emp == null) {
                model.addAttribute("errorMessage", "該当するユーザが存在しません。");
                return "error";
            }
            
            // フォームから取得したデータをログインユーザに設定
            emp.setEmpId(mypageForm.getEmpId());
            emp.setEmpName(mypageForm.getName());
            emp.setPassword(mypageForm.getPassword());
            emp.setBirthday(mypageForm.getBirthdate());
            emp.setGender(mypageForm.getGender());

            // ここで更新処理を行う
            employeeRepository.save(emp);

            // 更新が成功したら成功メッセージを表示
            model.addAttribute("successMessage", "ユーザ情報が更新されました。");

            // 更新が成功したら成功画面に遷移
            return "mypage_success";
        } catch (Exception e) {
            // エラーが発生した場合はエラー画面に遷移
            model.addAttribute("errorMessage", "システムエラーが発生しました。");
            return "error";
        }
    }
}
