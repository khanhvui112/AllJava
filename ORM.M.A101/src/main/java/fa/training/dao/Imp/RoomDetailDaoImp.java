package fa.training.dao.Imp;

import fa.training.dao.RoomDetailDao;
import fa.training.entity.RoomDetail;
import fa.training.entity.Seat;
import fa.training.services.RoomDetailServices;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author san vui
 * @create 16/10/2021 - 3:32 PM
 * @sanvankhanh@gmail.com
 */
public class RoomDetailDaoImp implements RoomDetailDao {

    //    find  all room detail
    @Override
    public List<RoomDetail> findAllRoomDetail() {
        try (Session session = HibernateUtils.getSession()) {
            return session.createQuery("FROM RoomDetail ", RoomDetail.class).list();
        }
    }

    //    insert new room detail
    @Override
    public boolean insertRoomDetail(RoomDetail roomDetail) {
        boolean check;
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(roomDetail);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            check = false;
        }
        return check;
    }

    //    update room detail by id
    @Override
    public void updateRoomDetailById(int roomDetailId) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            RoomDetail roomDetail = new RoomDetail();
            roomDetail = session.get(RoomDetail.class, roomDetailId);
            if (roomDetail != null) {
                RoomDetailServices roomDetailServices = new RoomDetailServices();
                roomDetail = roomDetailServices.inputRoomDetail(roomDetail);
                session.update(roomDetail);
                transaction.commit();
                System.out.println("Update room detail  complete");
            } else {
                System.out.println("Cannot find room detail id " + roomDetailId);
            }
        }
    }

    //    get room detail by  id
    @Override
    public RoomDetail getRoomDetailId(int roomDetailId) {
        try (Session session = HibernateUtils.getSession()) {
            return session.get(RoomDetail.class, roomDetailId);
        }
    }

    //    delete room detail by id
    @Override
    public void deleteByRoomDetailId(int roomDetailId) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            RoomDetail roomDetail = new RoomDetail();
            roomDetail = session.get(RoomDetail.class, roomDetailId);
            if (roomDetail != null) {
                session.delete(roomDetail);
                transaction.commit();
                System.out.println("Delete room detail complete!");
            } else {
                System.out.println("Cannot  find room detail id " + roomDetailId);
            }
        }
    }
}
