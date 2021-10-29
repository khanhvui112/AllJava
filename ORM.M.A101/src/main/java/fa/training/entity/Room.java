package fa.training.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author san vui
 * @create 16/10/2021 - 2:43 PM
 * @sanvankhanh@gmail.com
 */
@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @Column(name = "Room_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ROOM_ID;

    @Column(name = "Room_Name", columnDefinition = "varchar(255)")
    private String ROOM_NAME;

    @Column(name = "Seat_Quantity")
    private int SEAT_QUANTITY;

    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private RoomDetail  roomDetailList;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seatList;

    public Room() {
    }

    public Room(int ROOM_ID, String ROOM_NAME, int SEAT_QUANTITY) {
        this.ROOM_ID = ROOM_ID;
        this.ROOM_NAME = ROOM_NAME;
        this.SEAT_QUANTITY = SEAT_QUANTITY;
    }

    public int getROOM_ID() {
        return ROOM_ID;
    }

    public void setROOM_ID(int ROOM_ID) {
        this.ROOM_ID = ROOM_ID;
    }

    public String getROOM_NAME() {
        return ROOM_NAME;
    }

    public void setROOM_NAME(String ROOM_NAME) {
        this.ROOM_NAME = ROOM_NAME;
    }

    public int getSEAT_QUANTITY() {
        return SEAT_QUANTITY;
    }

    public void setSEAT_QUANTITY(int SEAT_QUANTITY) {
        this.SEAT_QUANTITY = SEAT_QUANTITY;
    }

    @Override
    public String toString() {
        return "ROOM_ID=" + ROOM_ID + "\t\t\t" +
                "ROOM_NAME=" + ROOM_NAME + "\t\t\t" +
                "SEAT_QUANTITY=" + SEAT_QUANTITY + "\n";
    }
}
