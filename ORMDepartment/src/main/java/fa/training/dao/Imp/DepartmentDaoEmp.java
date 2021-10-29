package fa.training.dao.Imp;

import fa.training.dao.DepartmentDao;
import fa.training.entity.Departments;
import fa.training.entity.Employees;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 10:04 AM
 * @sanvankhanh@gmail.com
 */
public class DepartmentDaoEmp implements DepartmentDao {
    @Override
    public boolean insertDepartment(List<Departments> departments) {
        Session session = null;
        Transaction transaction = null;
        try  {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            for (Departments departments1 : departments){
                session.save(departments1);
            }
            transaction.commit();
            return true;
        }catch (Exception exception) {
            assert transaction != null;
            transaction.rollback();
            return false;
        }finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public List<Employees> employeeList(int departmentId) {
        Departments departments = null;
        try(Session session = HibernateUtils.getSession()) {
            departments = session.get(Departments.class,departmentId);
        }
        return (departments!= null ? departments.getEmployees() : null);
    }

}
