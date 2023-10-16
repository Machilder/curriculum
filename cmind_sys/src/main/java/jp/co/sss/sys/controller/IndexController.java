package jp.co.sss.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.form.LoginForm;
import jp.co.sss.sys.repository.EmployeeRepository;

/**
 * コントローラークラス
 * このクラスはWebアプリケーションのコントローラーで、ユーザーからのリクエストを処理します。
 * @author Inoue Nami
 */
@RequestMapping("")
@Controller
public class IndexController {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * ログイン画面を表示するメソッド
     * @param loginForm ログインフォームのデータを受け取ります
     * @return login.html ログイン画面のテンプレートを返します
     */
    //@RequestMapping(path = "/login", method = RequestMethod.GET)
    @GetMapping(path = "/login")
    public String login(LoginForm loginForm) {
        return "login";
    }

    /**
     * ユーザーが入力した値を使用してログイン認証を行い、トップ画面に遷移するメソッド
     * @param loginForm ログインフォームのデータを受け取ります
     * @param request HTTPリクエスト情報を受け取ります
     * @param response HTTPレスポンス情報を受け取ります
     * @return top.html トップ画面のテンプレートを返します
     */
    //@RequestMapping(path = "/top", method = RequestMethod.POST)
    @PostMapping(path = "/top")
    public String login(LoginForm loginForm, HttpServletRequest request, HttpServletResponse response) {

        try {

            // データベースから従業員情報を取得
            Employee emp = employeeRepository.findByempIdAndPassword(loginForm.getEmpId(),loginForm.getPassword());
 
            // ログイン成功後、LoginFormに従業員名を設定
            loginForm.setEmpName(emp.getEmpName());

            // 従業員一覧を取得
            List<Employee> emplist = employeeRepository.findAll();

            // ログイン情報と従業員一覧をリクエスト属性に設定
            request.setAttribute("emplist", emplist);

            // ユーザ名をリクエスト属性に設定
            request.setAttribute("loginForm", loginForm);


            // ログイン成功時にトップ画面に遷移
            return "top";

        } catch (NullPointerException e) {
            // エラーが発生した場合はログイン画面に戻る
            return "login";
        }
    }
    
    @GetMapping("/mypage")
    public String mypage() {
        return "mypage";
    }
    
    @GetMapping("/mypage/update")
    public String mypageUpdate() {
        return "mypageUpdate";
    }    
}
