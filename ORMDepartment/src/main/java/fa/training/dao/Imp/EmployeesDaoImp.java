package fa.training.dao.Imp;

import fa.training.dao.EmployeesDao;
import fa.training.entity.Departments;
import fa.training.entity.Employees;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.Query;
import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 10:03 AM
 * @sanvankhanh@gmail.com
 */
public class EmployeesDaoImp implements EmployeesDao {
    @Override
    public boolean insertEmployee(List<Employees> employees) {
        Session session = null;
        Transaction transaction=null;
        try{
            session= HibernateUtils.getSession();
            transaction = session.beginTransaction();
            for (Employees employees1 : employees){
                session.save(employees1);
            }
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

    @Override
    public List<Employees> employeesList(int departmentId) {
        Departments departments = null;
        try(Session session = HibernateUtils.getSession()) {
            departments = session.get(Departments.class,departmentId);
        }
        return departments.getEmployees();
    }
}
