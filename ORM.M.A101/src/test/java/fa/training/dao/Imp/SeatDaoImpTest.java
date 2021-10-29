package fa.training.dao.Imp;

import fa.training.entity.Seat;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author san vui
 * @create 20/10/2021 - 10:26 PM
 * @sanvankhanh@gmail.com
 */
class SeatDaoImpTest {

    @org.junit.jupiter.api.Test
    void findAllSeat() {
    }

    @org.junit.jupiter.api.Test
    void insertSeat() {
        SeatDaoImp seatDaoImp = new SeatDaoImp();
        Seat seat = new Seat();
        seat.setROOM_ID(1);
        seat.setSEAT_ROW(2);
        seat.setSEAT_COLUMN("2");
        seat.setSEAT_TYPE("Normal");
        seat.setSEAT_STATUS("No Available");
        assertTrue(seatDaoImp.insertSeat(seat));
    }

    @org.junit.jupiter.api.Test
    void updateSeatById() {
    }

    @org.junit.jupiter.api.Test
    void getSeatById() {
    }

    @org.junit.jupiter.api.Test
    void deleteSeatById() {
    }
}