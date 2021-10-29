package fa.training.dao;

import fa.training.entity.Room;

import java.util.List;

/**
 * @author san vui
 * @create 16/10/2021 - 3:30 PM
 * @sanvankhanh@gmail.com
 */
public interface RoomDao {
    List<Room> findAllRoom();

    boolean insertRoom(Room room);

    void updateRoomById(int roomId);

    Room getRoomById(int roomId);

    void deleteRoomById(int roomId);
}
