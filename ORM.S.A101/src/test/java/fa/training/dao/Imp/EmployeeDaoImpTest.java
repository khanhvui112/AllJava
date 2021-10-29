package fa.training.dao.Imp;

import fa.training.entity.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author san vui
 * @create 19/10/2021 - 3:22 PM
 * @sanvankhanh@gmail.com
 */
class EmployeeDaoImpTest {

    @Test
    void insertEmployeeTrueTest() {
        Employee employee = new Employee("Nguyen","B");
        EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();
        assertTrue(employeeDaoImp.insertEmployee(employee));
    }

    @Test
    void insertEmployeeFalseTest() {
        Employee employee = new Employee("Hoang",null);
        EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();
        assertFalse(employeeDaoImp.insertEmployee(employee));
    }
}