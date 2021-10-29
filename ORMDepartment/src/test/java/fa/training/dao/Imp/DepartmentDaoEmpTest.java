package fa.training.dao.Imp;

import fa.training.entity.Departments;
import fa.training.entity.Employees;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author san vui
 * @create 19/10/2021 - 11:40 AM
 * @sanvankhanh@gmail.com
 */
class DepartmentDaoEmpTest {

    @Test
    void insertDepartmentTrue() {
        Departments department1 = new Departments("H0003",1);
        Departments department2 = new Departments("H002",1);
        Departments department3 = new Departments("H001",3);
        List<Departments> list = new ArrayList<>();
        DepartmentDaoEmp departmentDaoEmp = new DepartmentDaoEmp();
        list.add(department1);
        list.add(department2);
        list.add(department3);
        assertTrue(departmentDaoEmp.insertDepartment(list));
    }

    @Test
    void insertDepartmentFalse() {
        Departments department1 = new Departments("Failed1",2);
        Departments department2 = new Departments("Filed2",6);
        Departments department3 = new Departments("failed3",8);
        List<Departments> list = new ArrayList<>();
        DepartmentDaoEmp departmentDaoEmp = new DepartmentDaoEmp();
        list.add(department1);
        list.add(department2);
        list.add(department3);
        assertFalse(departmentDaoEmp.insertDepartment(list));
    }

    @Test
    void employeeListNotNull() {
        DepartmentDaoEmp departmentDaoEmp = new DepartmentDaoEmp();
        assertNotNull(departmentDaoEmp.employeeList(2));
    }
    @Test
    void employeeListNull() {
        DepartmentDaoEmp departmentDaoEmp = new DepartmentDaoEmp();
        assertNull(departmentDaoEmp.employeeList(1));
    }
}