package jp.co.sss.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.form.LoginForm;
import jp.co.sss.sys.repository.EmployeeService;

/**
 * コントローラークラス
 * このクラスはWebアプリケーションのコントローラーで、ユーザーからのリクエストを処理します。
 * @author Inoue Nami
 */
@RequestMapping("")
@Controller
public class IndexController {

    @Autowired
    EmployeeService empRepository;

    // ログイン情報を一時的に格納するための変数
    private String empId;
    private String password;

    /**
     * ログイン画面を表示するメソッド
     * @param loginForm ログインフォームのデータを受け取ります
     * @return login.html ログイン画面のテンプレートを返します
     */
    @RequestMapping(path = "/login", method = RequestMethod.GET)
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
    @RequestMapping(path = "/top", method = RequestMethod.POST)
    public String login(LoginForm loginForm, HttpServletRequest request, HttpServletResponse response) {
        // ログインフォームのデータをリクエスト属性に設定
        request.setAttribute("loginForm", loginForm);

        try {
            // リクエストからログイン情報を取得
            this.empId = loginForm.getEmpId();
            this.password = loginForm.getPassword();

            // データベースから従業員情報を取得
            Employee emp = empRepository.findByempId(empId);

            // パスワードが一致するか確認
            if (emp != null && password.equals(emp.getPassword())) {
                
                // ログイン成功後、LoginFormに従業員名を設定
                loginForm.setEmpName(emp.getEmpName());

                // 従業員一覧を取得
                List<Employee> emplist = empRepository.findAll();

                // ログイン情報と従業員一覧をリクエスト属性に設定
                request.setAttribute("emplist", emplist);
            } else {
                // パスワードが一致しない場合はログイン画面に戻る
                return "login";
            }

            // ログイン成功時にトップ画面に遷移
            return "top";

        } catch (NullPointerException e) {
            // エラーが発生した場合はログイン画面に戻る
            return "login";
        }
    }
}
