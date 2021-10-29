package fa.training.dao.Imp;

import fa.training.dao.EmployeeDao;
import fa.training.entity.Employee;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

/**
 * @author san vui
 * @create 15/10/2021 - 8:18 PM
 * @sanvankhanh@gmail.com
 */
public class EmployeeDaoImp implements EmployeeDao {
    @Override
    public List<Employee> findAll() {
       try(Session session = HibernateUtils.getSession()) {
            return session.createQuery("FROM Employee",Employee.class).list();
       }
    }
    @Override
    public boolean save(Employee employee) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            Integer newEmployeeId =(Integer) session.save(employee);
            transaction.commit();
            return newEmployeeId != null;
        }
    }

    @Override
    public void update(Employee employee) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getById(int id) {
        try (Session session = HibernateUtils.getSession()) {
            return session.get(Employee.class, id);
        }
    }
}
