package fa.training.dao;

import fa.training.entity.Seat;

import java.util.List;

/**
 * @author san vui
 * @create 16/10/2021 - 3:25 PM
 * @sanvankhanh@gmail.com
 */
public interface SeatDao {
    List<Seat> findAllSeat();

    boolean insertSeat(Seat seat);

    void updateSeatById(int seatId);

    Seat getSeatById(int seatId);

    void deleteSeatById(int seatId);
}
