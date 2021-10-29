package fa.training.dao;

import fa.training.entity.Employees;

import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 10:03 AM
 * @sanvankhanh@gmail.com
 */
public interface EmployeesDao {
    boolean insertEmployee(List<Employees> employees);
    List<Employees> employeesList(int departmentId);
}
