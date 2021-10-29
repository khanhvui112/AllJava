package fa.training.dao.Imp;

import fa.training.dao.RoomDao;
import fa.training.entity.Room;
import fa.training.entity.RoomDetail;
import fa.training.entity.Seat;
import fa.training.services.RoomServices;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * @author san vui
 * @create 16/10/2021 - 3:31 PM
 * @sanvankhanh@gmail.com
 */
public class RoomDaoImp implements RoomDao {

    //    Show all room  return List Room
    @Override
    public List<Room> findAllRoom() {
        try (Session session = HibernateUtils.getSession()) {
            return session.createQuery("FROM Room", Room.class).list();
        }
    }

    //    save room request param Room return true or false
    @Override
    public boolean insertRoom(Room room) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            transaction.commit();
            Integer integerCheck = (Integer) session.save(room);
            return integerCheck != 0;
        }
    }

    //    update room by roomId
    @Override
    public void updateRoomById(int roomId) {
        Room room;
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            room = session.get(Room.class, roomId);
            if (room == null) {
                System.out.println("Cannot find roomId " + roomId);
                return;
            } else {
                RoomServices roomServices = new RoomServices();
                room = roomServices.inputRoom(room);
                session.update(room);
                transaction.commit();
                System.out.println("Update room id " + roomId + " complete!");
            }
        }
    }

    //    find room by roomId return Object room
    @Override
    public Room getRoomById(int roomId) {
        try (Session session = HibernateUtils.getSession()) {
            return session.get(Room.class, roomId);
        }
    }

    //    Delete room by roomId
    @Override
    public void deleteRoomById(int roomId) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            Room room;
            room = session.get(Room.class, roomId);
            if (room != null) {
//      Delete table foreign key
                session.delete(room);
                transaction.commit();
                System.out.println("Delete room complete!");
            } else {
                System.out.println("Cannot find room!");
            }
        }
    }
}
