package jp.co.sss.sys.form;

/**
 * フォームクラス
 * @author Inoue Nami
 *
 */
public class LoginForm {

    /**
     * 社員番号
     */
    private String empId;
    /**
     * パスワード
     */
    private String password;

    /**
     * 社員名
     */    
    private String EmpName;

    //コンストラクタ
    public LoginForm() {
        this.empId = null;
        this.password = null;
    }

    //ゲッターセッター
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String EmpName) {
        this.password = password;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

}
