package dao;

import Interfaces.CheckExpriences;
import entites.Employee;

/**
 * @author san vui
 * @create 11/09/2021 - 15:50
 * @sanvankhanh@gmail.com
 */
public class SeniorClassValitor implements CheckExpriences {
    @Override
    public boolean isSenior(Employee employee) {
        return employee.getExperiences() >= 4;
    }
}
