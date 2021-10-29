package fa.training.dao;

import fa.training.entity.Employee;

import java.util.List;

/**
 * @author san vui
 * @create 15/10/2021 - 8:17 PM
 * @sanvankhanh@gmail.com
 */
public interface EmployeeDao {
    List<Employee> findAll();
    boolean save(Employee employee);
    void update(Employee employee);
    Employee getById(int id);
}
