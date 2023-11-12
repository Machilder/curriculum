package jp.co.sss.sys.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * フォームクラス
 * 
 * @author Inoue Nami
 *
 */
@Getter
@Setter
public class LoginForm {

    /**
     * 社員番号
     */
    @NotBlank(message = "社員番号は入力必須項目です。")
    @Size(max = 5, message = "社員番号は5文字以内で入力してください。")
    private String empId;
    /**
     * パスワード
     */
    @NotBlank(message = "パスワードは入力必須項目です。")
    @Size(max = 16, message = "パスワードは16文字以内で入力してください。")
    private String password;

    /**
     * 社員名
     */
    private String EmpName;

    // コンストラクタ
    public LoginForm() {
        clear();
    }

    public void clear() {
        this.empId = null;
        this.password = null;
        this.EmpName = null;
    }

}
