package fa.training.dao.Imp;

import fa.training.dao.LocationDao;
import fa.training.entity.Location;
import fa.training.utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 10:03 AM
 * @sanvankhanh@gmail.com
 */
public class LocationDaoImp implements LocationDao {
    @Override
    public boolean insertLocation(List<Location> list) {
        try(Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            for (Location location : list){
                session.save(location);
            }
            transaction.commit();
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
