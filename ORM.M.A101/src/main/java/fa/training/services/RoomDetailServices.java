package fa.training.services;

import fa.training.dao.Imp.RoomDetailDaoImp;
import fa.training.entity.RoomDetail;
import fa.training.utils.ValidateRoomDetail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * @author san vui
 * @create 17/10/2021 - 8:37 AM
 * @sanvankhanh@gmail.com
 */
public class RoomDetailServices {

    RoomDetailDaoImp roomDetailDaoImp = new RoomDetailDaoImp();

    //    show all RoomDetail
    public void getAllRoomDetail() {
        List<RoomDetail> roomDetailList;
        roomDetailList = roomDetailDaoImp.findAllRoomDetail();
        System.out.println("-----------------ALL ROOM DETAIL---------------");
        System.out.println(roomDetailList);
    }

    //    insert new Room detail
    public void insertRoomDetail() {
        RoomDetail roomDetail = new RoomDetail();
        roomDetail = inputRoomDetail(roomDetail);
        boolean checkSave = roomDetailDaoImp.insertRoomDetail(roomDetail);
        if (checkSave) {
            System.out.println("Save room detail complete!");
        } else {
            System.out.println("Save room detail failed");
        }
    }

    //    update room detail by id
    public void updateRoomDetailById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id room detail update: ");
        int id = scanner.nextInt();
        roomDetailDaoImp.updateRoomDetailById(id);
    }

    //    find Room Detail by Id return detail room
    public void getRoomDetailById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id room detail get: ");
        int id = scanner.nextInt();
        RoomDetail roomDetail = new RoomDetail();
        roomDetail = roomDetailDaoImp.getRoomDetailId(id);
        if (roomDetail != null) {
            System.out.println("------------Information room detail id " + id + "--------------------");
            System.out.println(roomDetail);
        } else {
            System.out.println("Cannot find room detail id is " + id);
        }
    }

    //    delete room detail by id
    public void deleteRoomDetailById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id room detail delete: ");
        int id = scanner.nextInt();
        roomDetailDaoImp.deleteByRoomDetailId(id);
    }

    //    input information room detail
    public RoomDetail inputRoomDetail(RoomDetail roomDetail) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        System.out.println("Input active date(d-M-yyyy): ");
        do {
            check = false;
            try {
                String activeDateStr = String.valueOf(scanner.nextLine());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.parse(activeDateStr, formatter);
                roomDetail.setACTIVE_DATE(localDate);
            } catch (Exception e) {
                System.out.println("Input active date again(dd/MM/yyyy): ");
                check = true;
            }
        } while (check);

        System.out.println("Input room description: ");
        do {
            check = false;
            try {
                roomDetail.setROOM_DESCRIPTION(String.valueOf(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Input room description again: ");
                check = true;
            }
        } while (check);

        System.out.println("Input room id: ");
        do {
            check = false;
            try {
                roomDetail.setROOM_ID(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Input room id again: ");
                check = true;
            }
        } while (check);

        System.out.println("Input room rate: ");
        do {
            check = false;
            try {
                roomDetail.setROOM_RATE(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Input room rate again: ");
                check = true;
            }
        } while (check);

        return roomDetail;
    }
}
