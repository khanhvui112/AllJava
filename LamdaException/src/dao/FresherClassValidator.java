package dao;

import Interfaces.CheckScore;
import entites.Student;

/**
 * @author san vui
 * @create 11/09/2021 - 13:18
 * @sanvankhanh@gmail.com
 */
public class FresherClassValidator implements CheckScore {
    @Override
    public boolean isPassed(Student student) {
        return student.getEntryTest() >= 65;
    }
}
