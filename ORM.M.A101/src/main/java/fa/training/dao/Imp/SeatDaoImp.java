package fa.training.dao.Imp;

import fa.training.dao.SeatDao;
import fa.training.entity.Seat;
import fa.training.services.SeatServices;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

/**
 * @author san vui
 * @create 16/10/2021 - 3:30 PM
 * @sanvankhanh@gmail.com
 */
public class SeatDaoImp implements SeatDao {

    //    Find all Seat return List Seat
    @Override
    public List<Seat> findAllSeat() {
        try (Session session = HibernateUtils.getSession()) {
            return session.createQuery(" FROM Seat", Seat.class).list();
        }
    }

    //    Save Seat return true if complete else return false
    @Override
    public boolean insertSeat(Seat seat) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(seat);
            Integer integerCheck = (Integer) session.save(seat);
            transaction.commit();
            return integerCheck != 0;
        }catch (Exception e){
            System.out.println("Add seat failed!");
            return false;
        }
    }

    //    update Seat by seatId request param is seatId
    @Override
    public void updateSeatById(int seatId) {
        Seat seatCheck;
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            seatCheck = session.get(Seat.class, seatId);
            if (seatCheck == null) {
                System.out.println("Cannot find seatId " + seatId);
                return;
            } else {
                SeatServices seatServices = new SeatServices();
                seatCheck = seatServices.inputSeat(seatCheck);
                session.update(seatCheck);
                transaction.commit();
                System.out.println("Update seatId " + seatCheck.getSeatId() + " complete");
            }
        } catch (Exception exception) {
            System.out.println("Update seatId " + seatId + " failed");
        }
    }

    //    Find Seat return a Seat
    @Override
    public Seat getSeatById(int seatId) {
        try (Session session = HibernateUtils.getSession()) {
            return session.get(Seat.class, seatId);
        }
    }

    //    Delete Seat request param seatId
    @Override
    public void deleteSeatById(int seatId) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            Seat seat = session.get(Seat.class, seatId);
            if (seat == null) {
                System.out.println("Cannot find seatId " + seatId);
            } else {
                session.delete(seat);
                transaction.commit();
                System.out.println("Delete seat have id " + seatId + " complete");
            }
        }
    }
}
