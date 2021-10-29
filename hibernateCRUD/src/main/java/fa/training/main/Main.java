package fa.training.main;

import fa.training.dao.Imp.EmployeeDaoImp;
import fa.training.dao.Imp.StudentDaoImp;
import fa.training.entity.Employee;
import fa.training.entity.Student;

import java.util.List;

/**
 * @author san vui
 * @create 15/10/2021 - 8:22 PM
 * @sanvankhanh@gmail.com
 */
public class Main {
    public static void main(String[] args) {
       EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();
        StudentDaoImp studentDaoImp =  new StudentDaoImp();
        List<Employee> employeeList;
        List<Student> studentList;
        studentList = studentDaoImp.findAll();


//        create Employee
        Employee employee = new Employee("Vui Ne","Nam","Lao Cai");
        Employee employeeUpdate = new Employee(3,"Nguyen Thi B","Nữ","Lao cAI lAO cAI 1");

//        save employee to database
        boolean saveCheck = employeeDaoImp.save(employee);
        if(saveCheck!= false){
            System.out.println("Add employee success");
        }else {
            System.out.println("Add employee failed");
        }

    //        update employee
       employeeDaoImp.update(employeeUpdate);
    //get employee by  Id
        Employee getEmployee = new Employee();
        getEmployee = employeeDaoImp.getById(2);
        System.out.println("Employee id=2:\n"+getEmployee);
        System.out.println(studentList);

    }
}
