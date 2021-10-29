package fa.training.utils;

import fa.training.entity.Room;
import fa.training.entity.RoomDetail;
import fa.training.entity.Seat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author san vui
 * @create 16/10/2021 - 2:43 PM
 * @sanvankhanh@gmail.com
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Room.class);
        configuration.addAnnotatedClass(Seat.class);
        configuration.addAnnotatedClass(RoomDetail.class);
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession() {
        sessionFactory.close();
    }
}
