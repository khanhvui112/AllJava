package fa.training.dao;

import fa.training.entity.Student;

import java.util.List;

/**
 * @author san vui
 * @create 15/10/2021 - 8:45 PM
 * @sanvankhanh@gmail.com
 */
public interface StudentDao {
    List<Student> findAll();
}
