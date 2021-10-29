package fa.training.dao;

import fa.training.entity.Departments;
import fa.training.entity.Employees;

import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 10:03 AM
 * @sanvankhanh@gmail.com
 */
public interface DepartmentDao {
    boolean insertDepartment(List<Departments> departments);
    List<Employees> employeeList(int departmentId);
}
