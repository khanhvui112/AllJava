package dao;

import Interfaces.CheckExpriences;
import entites.Employee;

/**
 * @author san vui
 * @create 11/09/2021 - 15:57
 * @sanvankhanh@gmail.com
 */
public class NoSeniorClassValidator implements CheckExpriences {
    @Override
    public boolean isSenior(Employee employee) {
        return employee.getExperiences()<4;
    }
}
