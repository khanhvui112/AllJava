package fa.training.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author san vui
 * @create 16/10/2021 - 2:44 PM
 * @sanvankhanh@gmail.com
 */
@Entity
@Table(name = "ROOMDETAIL")
public class RoomDetail {

    @Id
    @Column(name = "Room_Detail_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ROOM_DETAIL_ID;

    @Column(name = "Room_Id")
    private int ROOM_ID;

    @OneToOne(optional = false)
    @JoinColumn(name = "Room_Id", referencedColumnName = "Room_Id", insertable = false, updatable = false)
    private Room room;

    @Column(name = "Room_Rate")
    private int ROOM_RATE;

    @Column(name = "Active_Date")
    private LocalDate ACTIVE_DATE;

    @Column(name = "Room_Description")
    private String ROOM_DESCRIPTION;

    public RoomDetail() {
    }

    public RoomDetail(int ROOM_ID, int ROOM_RATE, LocalDate ACTIVE_DATE, String ROOM_DESCRIPTION) {
        this.ROOM_ID = ROOM_ID;
        this.ROOM_RATE = ROOM_RATE;
        this.ACTIVE_DATE = ACTIVE_DATE;
        this.ROOM_DESCRIPTION = ROOM_DESCRIPTION;
    }

    public RoomDetail(int ROOM_ID, Room room, int ROOM_RATE, LocalDate ACTIVE_DATE, String ROOM_DESCRIPTION) {
        this.ROOM_ID = ROOM_ID;
        this.room = room;
        this.ROOM_RATE = ROOM_RATE;
        this.ACTIVE_DATE = ACTIVE_DATE;
        this.ROOM_DESCRIPTION = ROOM_DESCRIPTION;
    }

    public int getROOM_DETAIL_ID() {
        return ROOM_DETAIL_ID;
    }

    public void setROOM_DETAIL_ID(int ROOM_DETAIL_ID) {
        this.ROOM_DETAIL_ID = ROOM_DETAIL_ID;
    }

    public int getROOM_ID() {
        return ROOM_ID;
    }

    public void setROOM_ID(int ROOM_ID) {
        this.ROOM_ID = ROOM_ID;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getROOM_RATE() {
        return ROOM_RATE;
    }

    public void setROOM_RATE(int ROOM_RATE) {
        this.ROOM_RATE = ROOM_RATE;
    }

    public LocalDate getACTIVE_DATE() {
        return ACTIVE_DATE;
    }

    public void setACTIVE_DATE(LocalDate ACTIVE_DATE) {
        this.ACTIVE_DATE = ACTIVE_DATE;
    }

    public String getROOM_DESCRIPTION() {
        return ROOM_DESCRIPTION;
    }

    public void setROOM_DESCRIPTION(String ROOM_DESCRIPTION) {
        this.ROOM_DESCRIPTION = ROOM_DESCRIPTION;
    }

    @Override
    public String toString() {
        return "ROOM_DETAIL_ID=" + ROOM_DETAIL_ID + "\t\t\t" +
                "ROOM_ID=" + ROOM_ID + "\t\t\t" +
                "ROOM_RATE=" + ROOM_RATE + "\t\t\t" +
                "ACTIVE_DATE=" + ACTIVE_DATE + "\t\t\t" +
                "ROOM_DESCRIPTION=" + ROOM_DESCRIPTION + "\t\t\t" + "\n";
    }
}
