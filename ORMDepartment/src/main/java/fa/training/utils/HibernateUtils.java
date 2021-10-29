package fa.training.utils;

import fa.training.entity.Departments;
import fa.training.entity.Employees;
import fa.training.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author san vui
 * @create 19/10/2021 - 9:58 AM
 * @sanvankhanh@gmail.com
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Location.class);
        configuration.addAnnotatedClass(Departments.class);
        configuration.addAnnotatedClass(Employees.class);
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession() {
        sessionFactory.close();
    }
}
