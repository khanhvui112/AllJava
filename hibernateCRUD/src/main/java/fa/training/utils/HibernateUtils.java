package fa.training.utils;

import fa.training.entity.Employee;
import fa.training.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author san vui
 * @create 15/10/2021 - 7:01 AM
 * @sanvankhanh@gmail.com
 */
public class HibernateUtils {
    private  static  final SessionFactory sessionFactory;
    static {
        Configuration configuration = new Configuration();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Student.class);
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    public  static  Session getSession(){
        return  sessionFactory.openSession();
    }

    public  static  void closeSession(){
        sessionFactory.close();
    }
}
