package fa.training.main;

import fa.training.dao.EmployeeDao;
import fa.training.dao.Imp.EmployeeDaoImp;
import fa.training.entity.Employee;

/**
 * @author san vui
 * @create 19/10/2021 - 3:15 PM
 * @sanvankhanh@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Nguyen","A");
        EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();
        boolean checkInsert = employeeDaoImp.insertEmployee(employee);
        if (checkInsert){
            System.out.println("Insert employee success!");
        }else {
            System.out.println("Insert employee failed");
        }
    }
}
