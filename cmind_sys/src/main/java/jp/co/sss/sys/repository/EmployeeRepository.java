package jp.co.sss.sys.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.sss.sys.entity.Employee;

/**
 * リポジトリーインターフェース
 * @author Inoue Nami
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    /**
     * ユーザー情報 主キー検索
     * @return -
     */
    public Employee findByempId(String empId);
    
    public List<Employee> findAll();

}
