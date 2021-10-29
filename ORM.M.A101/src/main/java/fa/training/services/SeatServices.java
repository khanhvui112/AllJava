package fa.training.services;

import fa.training.dao.Imp.SeatDaoImp;
import fa.training.entity.Room;
import fa.training.entity.RoomDetail;
import fa.training.entity.Seat;
import fa.training.utils.HibernateUtils;
import fa.training.utils.ValidateSeat;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * @author san vui
 * @create 16/10/2021 - 3:55 PM
 * @sanvankhanh@gmail.com
 */
public class SeatServices {

    //    Show all Seat
    public void showSeat() {
        SeatDaoImp seatDaoImp = new SeatDaoImp();
        List<Seat> listSeat;
        listSeat = seatDaoImp.findAllSeat();
        System.out.println("------Show all seat-----------");
        System.out.println(listSeat);
    }

    //    Save Seat
    public void saveSeat() {
        Seat seat = new Seat();
        seat = inputSeat(seat);
        SeatDaoImp seatDaoImp = new SeatDaoImp();
        boolean checkSave = seatDaoImp.insertSeat(seat);
        if (checkSave != false) {
            System.out.println("Save seat  complete");
        } else {
            System.out.println("Save seat  failed");
        }
    }

    //    Update Seat by seatId
    public void updateSeat() {
        System.out.println("-------------UPDATE SEAT-----------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input seatId Update: ");
        int seatId = scanner.nextInt();
        SeatDaoImp seatDaoImp = new SeatDaoImp();
        seatDaoImp.updateSeatById(seatId);
    }

    //    Find Seat by seatId
    public void findBySeatId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input seatId search: ");
        int seatId = scanner.nextInt();
        SeatDaoImp seatDaoImp = new SeatDaoImp();
        Seat seat;
        seat = seatDaoImp.getSeatById(seatId);
        if (seat != null) {
            System.out.println("Information of seatId " + seatId + "\n");
            System.out.println(seat);
        } else {
            System.out.println("Cannot find seatId " + seatId + "\n");
        }

    }

    //    delete Seat
    public void deleteBySeatId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input seatId remove: ");
        int seatId = scanner.nextInt();
        SeatDaoImp seatDaoImp = new SeatDaoImp();
        seatDaoImp.deleteSeatById(seatId);
    }

    //    Input information Seat return room
    public Seat inputSeat(Seat seat) {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);

        do {
            check = false;
            try {
                System.out.println("Input roomId: ");
                seat.setROOM_ID(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                check = true;
            }
        } while (check);

        do {
            check = false;
            try {
                System.out.println("Input seat column: ");
                seat.setSEAT_COLUMN(String.valueOf(scanner.nextLine()));
            } catch (Exception e) {
                check = true;
            }
        } while (check);

        do {
            check = false;
            try {
                System.out.println("Input seat row: ");
                seat.setSEAT_ROW(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                check = true;
            }
        } while (check);

        System.out.println("Input seat status: ");
        do {
            check = false;
            try {
                seat.setSEAT_STATUS(String.valueOf(scanner.nextLine()));
                check = !(ValidateSeat.isSeatStatus(seat.getSEAT_STATUS()));
                if (check != false) {
                    System.out.println("Please input seat status again: ");
                }
            } catch (Exception e) {
                check = true;
            }
        } while (check);

        System.out.println("Input seat type: ");
        do {
            check = false;
            try {
                seat.setSEAT_TYPE(String.valueOf(scanner.nextLine()));
                check = !(ValidateSeat.isSeatType(seat.getSEAT_TYPE()));
                if (check != false) {
                    System.out.println("Please input seat type again: ");
                }
            } catch (Exception e) {
                check = true;
            }
        } while (check);

        return seat;
    }
}
