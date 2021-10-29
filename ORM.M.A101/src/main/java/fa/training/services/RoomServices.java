package fa.training.services;

import fa.training.dao.Imp.RoomDaoImp;
import fa.training.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author san vui
 * @create 16/10/2021 - 9:56 PM
 * @sanvankhanh@gmail.com
 */
public class RoomServices {

    RoomDaoImp roomDaoImp = new RoomDaoImp();

    //    show all list room
    public void showRoom() {
        List<Room> roomList = new ArrayList<>();
        roomList = roomDaoImp.findAllRoom();
        System.out.println("------------ALL ROOM -------------");
        System.out.println(roomList);
    }

    //    add room
    public void addRoom() {
        System.out.println("----------Input information room --------------");
        Room room = new Room();
        room = inputRoom(room);
        boolean check = roomDaoImp.insertRoom(room);
        if (check != false) {
            System.out.println("Input room complete!");
        } else {
            System.out.println("Input room failed!");
        }
    }

    //    update room by roomId
    public void updateRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input roomId update: ");
        int roomId = scanner.nextInt();
        roomDaoImp.updateRoomById(roomId);
    }

    //    find room by room Id
    public void findRoomById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input roomId update: ");
        int roomId = scanner.nextInt();
        Room room;
        room = roomDaoImp.getRoomById(roomId);
        if (room != null) {
            System.out.println("Information of room id " + roomId + "\n");
            System.out.println(room);
        } else {
            System.out.println("Cannot find room have id " + roomId);
        }
    }

    //    delete room by roomId
    public void deleteByRoomId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input roomId delete: ");
        int roomId = scanner.nextInt();
        roomDaoImp.deleteRoomById(roomId);
    }

    //    Input information room
    public Room inputRoom(Room room) {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);

        do {
            check = false;
            try {
                System.out.println("Input room name: ");
                room.setROOM_NAME(String.valueOf(scanner.nextLine()));
            } catch (Exception e) {
                check = true;
            }
        } while (check);

        do {
            check = false;
            try {
                System.out.println("Input seat quantity: ");
                room.setSEAT_QUANTITY(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                check = true;
            }
        } while (check);

        return room;
    }
}
