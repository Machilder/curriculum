//package jp.co.sss.sys.repository;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import jp.co.sss.sys.entity.Employee;
//
//@Service
//@Transactional
//public class EmployeeService{
//    @Autowired
//    EmployeeRepository repository;
//
//    // データベースよりフォーラム(掲示板)の一覧を取得
//    public List<Employee> findAll() {
//        return repository.findAll();
//    }
//
//    public Employee findByempId(String empId) {
//        return null;
//    }
//    
//    // データベースに値を登録
//    //public void insert(Employee forum) {
//    //    repository.save(forum);
//    //}
//}
