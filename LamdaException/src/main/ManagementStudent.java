package main;

import Interfaces.CheckExpriences;
import Interfaces.CheckScore;
import dao.FresherClassValidator;
import dao.NoSeniorClassValidator;
import dao.PreFresherClassValidator;
import dao.SeniorClassValitor;
import entites.Employee;
import entites.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author san vui
 * @create 11/09/2021 - 13:21
 * @sanvankhanh@gmail.com
 */
public class ManagementStudent {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList();
        Student student = new Student("san khanh", 85);
        Student student1= new Student("san khanh1", 65);
        Student student2 = new Student("san khanh2", 55);
        Student student3 = new Student("san khanh3", 25);
        Student student4 = new Student("san khanh4", 15);
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        System.out.println("Fresher check");
        printResults(studentList,new FresherClassValidator());

        System.out.println("\nPreFresher Check");
        printResults(studentList,new PreFresherClassValidator());

//        Lamda
        System.out.println("\nLammmda");
        printResults(studentList,s->s.getEntryTest()>=65);
//        write full
        printResults(studentList,(Student s) ->{return  s.getEntryTest()>=65;});

        printResults(studentList,s->s.getEntryTest()>=55);


        ///
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee(1,"san khanh",6);
        Employee employee1= new Employee(2,"san vui",3);
        Employee employee2 = new Employee(3,"san khanh vui",1);
        employeeList.add(employee1);
        employeeList.add(employee);
        employeeList.add(employee2);

//        cách thông thuong
        System.out.println("Defaults");
        printEmploy(employeeList,new SeniorClassValitor());
        System.out.println("Lamda Full");
        printEmploy(employeeList,(Employee emp)->{return emp.getExperiences()>=4;});

        System.out.println("Lamda no full");
        printEmploy(employeeList,e->e.getExperiences()>=4);

        System.out.println("Lamda su dung prel");
    }
    public  static  void printResults(List<Student> studentList, CheckScore checkScore){
        for (Student student: studentList){
            if (checkScore.isPassed(student)){
                System.out.println(student.getName()+" :  passed");
            }else {
                System.out.println(student.getName()+":  failed");
            }
        }
    }

    public  static  void printEmploy(List<Employee> employeeList, CheckExpriences checkExpriences){
        for (Employee employee: employeeList){
            if (checkExpriences.isSenior(employee)){
                System.out.println(employee.getName()+":  sennior");
            }else {
                System.out.println(employee.getName()+":  no senior");
            }
        }
    }
}
