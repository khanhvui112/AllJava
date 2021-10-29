package fa.training.entity;

import org.hibernate.annotations.Check;

import javax.persistence.*;

/**
 * @author san vui
 * @create 16/10/2021 - 2:36 PM
 * @sanvankhanh@gmail.com
 */
@Entity
@Check(constraints = "Seat_Status ='Available' or Seat_Status='Not Available' or Seat_Status='Booked'")
@Table(name = "SEAT",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"Room_id"})})
public class Seat {
    @Id
    @Column(name = "Seat_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;

    @Column(name = "room_Id")
    private int room_Id;

    @Column(columnDefinition = "varchar(255)",
            name = "Seat_Column")
    private String SEAT_COLUMN;

    @Column(name = "Seat_Row")
    private int SEAT_ROW;

    @Column(columnDefinition = "varchar(255)",
            name = "Seat_Status")
    private String SEAT_STATUS;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_Id", referencedColumnName = "Room_Id", insertable = false, updatable = false)
    private Room room;

    @Column(columnDefinition = "varchar(255) check(Seat_Type ='VIP' or Seat_Type='Normal') ",
            name = "Seat_Type")
    private String SEAT_TYPE;

    public Seat() {
    }

    public Seat(int ROOM_ID, String SEAT_COLUMN, int SEAT_ROW, String SEAT_STATUS, String SEAT_TYPE) {
        this.seatId = seatId;
        this.room_Id = ROOM_ID;
        this.SEAT_COLUMN = SEAT_COLUMN;
        this.SEAT_ROW = SEAT_ROW;
        this.SEAT_STATUS = SEAT_STATUS;
        this.SEAT_TYPE = SEAT_TYPE;
    }

    public Seat(int seatId, int ROOM_ID, String SEAT_COLUMN, int SEAT_ROW, String SEAT_STATUS, String SEAT_TYPE) {
        this.seatId = seatId;
        this.room_Id = ROOM_ID;
        this.SEAT_COLUMN = SEAT_COLUMN;
        this.SEAT_ROW = SEAT_ROW;
        this.SEAT_STATUS = SEAT_STATUS;
        this.room = room;
        this.SEAT_TYPE = SEAT_TYPE;
    }

    public Seat(int seatId, int ROOM_ID, String SEAT_COLUMN, int SEAT_ROW, String SEAT_STATUS, Room room, String SEAT_TYPE) {
        this.seatId = seatId;
        this.room_Id = ROOM_ID;
        this.SEAT_COLUMN = SEAT_COLUMN;
        this.SEAT_ROW = SEAT_ROW;
        this.SEAT_STATUS = SEAT_STATUS;
        this.room = room;
        this.SEAT_TYPE = SEAT_TYPE;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getROOM_ID() {
        return room_Id;
    }

    public void setROOM_ID(int ROOM_ID) {
        this.room_Id = ROOM_ID;
    }

    public String getSEAT_COLUMN() {
        return SEAT_COLUMN;
    }

    public void setSEAT_COLUMN(String SEAT_COLUMN) {
        this.SEAT_COLUMN = SEAT_COLUMN;
    }

    public int getSEAT_ROW() {
        return SEAT_ROW;
    }

    public void setSEAT_ROW(int SEAT_ROW) {
        this.SEAT_ROW = SEAT_ROW;
    }

    public String getSEAT_STATUS() {
        return SEAT_STATUS;
    }

    public void setSEAT_STATUS(String SEAT_STATUS) {
        this.SEAT_STATUS = SEAT_STATUS;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getSEAT_TYPE() {
        return SEAT_TYPE;
    }

    public void setSEAT_TYPE(String SEAT_TYPE) {
        this.SEAT_TYPE = SEAT_TYPE;
    }

    @Override
    public String toString() {
        return "seatId=" + seatId + "\t\t\t" +
                "ROOM_ID=" + room_Id + "\t\t\t" +
                "SEAT_COLUMN=" + SEAT_COLUMN + "\t\t\t" +
                "SEAT_ROW=" + SEAT_ROW + "\t\t\t" +
                "SEAT_STATUS=" + SEAT_STATUS + "\t\t\t" +
                "SEAT_TYPE=" + SEAT_TYPE + "\t\t\t" + "\n";
    }
}
