package jp.co.sss.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;
/**
 * エンティティクラス
 * @author Inoue Nami
 *
 */
@Data
@Entity
@Table(name = "employee")
public class Employee  {

    @emp_id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
	private String emp_id;
	@Column(name = "emp_name")
	private String emp_name;
	@Column(name = "password")
	private String password;
	
    /*
     * //ゲッターセッター public String getEmpId() { return empId; }
     * 
     * public void setEmpId(String empId) { this.empId = empId; }
     * 
     * public String getEmpName() { return empName; }
     * 
     * public void setEmpName(String empName) { this.empName = empName; }
     * 
     * public String getPassword() { return password; }
     * 
     * public void setPassword(String password) { this.password = password; }
     */


}
