package jp.co.sss.sys.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jp.co.sss.sys.entity.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MypageForm {
    
    private String empId;
    
    @NotBlank(message = "名前は入力必須項目です。")
    @Size(max = 16, message = "名前は16文字以内で入力してください。")
    private String name;
    
    @NotBlank(message = "パスワードは入力必須項目です。")
    @Size(max = 16, message = "パスワードは16文字以内で入力してください。")
    private String password;
    
    
    private Integer gender;
    
    @NotBlank(message = "生年月日は入力必須項目です。")
     private String birthdate;
    
    // コンストラクタ
    public MypageForm() {
        clear();
    }

    public void clear() {
        this.empId = null;
        this.name = null;
        this.password = null;
        this.gender = 0;
        this.birthdate = null;
    }

    // 一括でEmployee情報を設定するメソッド
    public void setMypage(Employee emp) {
        this.empId = emp.getEmpId();
        this.name = emp.getEmpName();
        this.password = emp.getPassword();
        this.birthdate = emp.getBirthday();
        this.gender = emp.getGender();
        // 他の情報も必要に応じて設定
    }
    
}