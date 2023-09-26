package jp.co.sss.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * エンティティクラス
 * @author Inoue Nami
 *
 */
@Entity
@Table(name = "employee")
public class Employee  {

	/**
	 * 社員番号
	 */
	@Id
	private String empId;
	
	/**
	 * 社員名
	 */
	@Column(name = "emp_namme")
	private String empName;
	private String password;
	
	//ゲッターセッター
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	


}
