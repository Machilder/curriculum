package jp.co.sss.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * エンティティクラス
 * 
 * @author Inoue Nami
 *
 */
@Entity
@Table(name = "employee")
@Data
public class Employee {

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "password")
    private String password;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "gender")
    private Integer gender;
}
