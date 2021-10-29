package fa.training.dao.Imp;

import fa.training.dao.EmployeeDao;
import fa.training.entity.Employee;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author san vui
 * @create 19/10/2021 - 3:12 PM
 * @sanvankhanh@gmail.com
 */
public class EmployeeDaoImp implements EmployeeDao {
    @Override
    public boolean insertEmployee(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return true;
        }catch (Exception exception){
            assert transaction != null;
            transaction.rollback();
            return false;
        }finally {
            assert session != null;
            session.close();
        }
    }
}
