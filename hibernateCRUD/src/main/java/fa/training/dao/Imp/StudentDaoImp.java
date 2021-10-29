package fa.training.dao.Imp;

import fa.training.dao.StudentDao;
import fa.training.entity.Student;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

/**
 * @author san vui
 * @create 15/10/2021 - 8:45 PM
 * @sanvankhanh@gmail.com
 */
public class StudentDaoImp implements StudentDao {
    @Override
    public List<Student> findAll() {
        try(Session session = HibernateUtils.getSession()) {
            return session.createQuery("FROM Student ",Student.class).list();
        }
    }
}
