package fa.training.dao.Imp;

import fa.training.entity.Departments;
import fa.training.entity.Employees;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author san vui
 * @create 19/10/2021 - 10:19 AM
 * @sanvankhanh@gmail.com
 */
class EmployeesDaoImpTest {

    @Test
    void insertEmployeeFalse() {

    }
    @Test
    void insertEmployeeTrue() {
        Employees employees1 = new Employees("San","Khanh","sa23232@gmail.com",15623.25,2);
        Employees employees2 = new Employees("Khanh","Vui","sa123232@gmail.com",15623.25,3);
        Employees employees3 = new Employees("Vui","San","sa11323232@gmail.com",15623.25,3);
        List<Employees> list = new ArrayList<>();
        EmployeesDaoImp employeesDaoImp = new EmployeesDaoImp();
        list.add(employees1);
        list.add(employees2);
        list.add(employees3);
        assertTrue(employeesDaoImp.insertEmployee(list));
    }

    @Test
    void employeesListNotNull() {

    }
}