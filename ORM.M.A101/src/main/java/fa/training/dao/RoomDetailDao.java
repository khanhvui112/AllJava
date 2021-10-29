package fa.training.dao;

import fa.training.entity.RoomDetail;

import java.util.List;

/**
 * @author san vui
 * @create 16/10/2021 - 3:30 PM
 * @sanvankhanh@gmail.com
 */
public interface RoomDetailDao {
    List<RoomDetail> findAllRoomDetail();

    boolean insertRoomDetail(RoomDetail roomDetail);

    void updateRoomDetailById(int roomDetailId);

    RoomDetail getRoomDetailId(int roomDetailId);

    void deleteByRoomDetailId(int roomDetailId);
}
