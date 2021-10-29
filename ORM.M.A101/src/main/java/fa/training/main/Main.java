package fa.training.main;

import fa.training.services.RoomDetailServices;
import fa.training.services.RoomServices;
import fa.training.services.SeatServices;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.Scanner;

/**
 * @author san vui
 * @create 16/10/2021 - 4:05 PM
 * @sanvankhanh@gmail.com
 */
public class Main {
    public static void menu() {
        System.out.println("--------------CINEMA-----------------");
        System.out.println("1. SEAT");
        System.out.println("2. ROOM");
        System.out.println("3. ROOM DETAIL");
        System.out.println("0. Exit");
        System.out.println("Choose case ");
    }

    public static void menuRoom() {
        System.out.println("--------------ROOM-----------------");
        System.out.println("1. Show all Room");
        System.out.println("2. Add new Room");
        System.out.println("3. Update Room");
        System.out.println("4. Delete Room");
        System.out.println("5. Find Room");
        System.out.println("0. Back to menu");
        System.out.println("Choose case Room");
    }

    public static void menuRoomDetail() {
        System.out.println("--------------ROOM DETAIL-----------------");
        System.out.println("1. Show all Room Detail");
        System.out.println("2. Add new Room Detail");
        System.out.println("3. Update Room Detail");
        System.out.println("4. Delete Room Detail");
        System.out.println("5. Find Room Detail");
        System.out.println("0. Back to menu");
        System.out.println("Choose case Room");
    }

    public static void menuSeat() {
        System.out.println("--------------SEAT-----------------");
        System.out.println("1. Show all Seat");
        System.out.println("2. Add new Seat");
        System.out.println("3. Update Seat");
        System.out.println("4. Delete Seat");
        System.out.println("5. Find Seat");
        System.out.println("0. Back to menu");
        System.out.println("Choose case Seat");
    }

    public static void main(String[] args) {
        SeatServices seatServices = new SeatServices();
        RoomServices roomServices = new RoomServices();
        RoomDetailServices roomDetailServices = new RoomDetailServices();

//        open session
        Session session = HibernateUtils.getSession();
        int choose;
        do {
            menu();
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            if (choose == 1) {
                int choose1;
                do {
                    menuSeat();
                    choose1 = scanner.nextInt();
                    switch (choose1) {
                        case 1:
                            seatServices.showSeat();
                            break;
                        case 2:
                            seatServices.saveSeat();
                            break;
                        case 3:
                            seatServices.updateSeat();
                            break;
                        case 4:
                            seatServices.deleteBySeatId();
                            break;
                        case 5:
                            seatServices.findBySeatId();
                            break;
                    }
                } while (choose1 != 0);
            }

            if (choose == 2) {
                int choose2;
                do {
                    menuRoom();
                    choose2 = scanner.nextInt();
                    switch (choose2) {
                        case 1:
                            roomServices.showRoom();
                            break;
                        case 2:
                            roomServices.addRoom();
                            break;
                        case 3:
                            roomServices.updateRoom();
                            break;
                        case 4:
                            roomServices.deleteByRoomId();
                            break;
                        case 5:
                            roomServices.findRoomById();
                            break;

                    }
                } while (choose2 != 0);

            }
            int choose3;
            if (choose == 3) {
                do {
                    menuRoomDetail();
                    choose3 = scanner.nextInt();
                    switch (choose3) {
                        case 1:
                            roomDetailServices.getAllRoomDetail();
                            break;
                        case 2:
                            roomDetailServices.insertRoomDetail();
                            break;
                        case 3:
                            roomDetailServices.updateRoomDetailById();
                            break;
                        case 4:
                            roomDetailServices.deleteRoomDetailById();
                            break;
                        case 5:
                            roomDetailServices.getRoomDetailById();
                            break;
                    }


                } while (choose3 != 0);
            }

        } while (choose != 0);

//        close session
        session.close();
    }
}
