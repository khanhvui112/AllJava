package fa.training.dao.Imp;

import fa.training.entity.Location;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author san vui
 * @create 19/10/2021 - 10:57 AM
 * @sanvankhanh@gmail.com
 */
class LocationDaoImpTest {

    @Test
    void insertLocationTrue() {
        Location location1 = new Location("Lao Cai","Bac ha");
        Location location2 = new Location("Yen Bai","Ga Mau A");
        Location location3 = new Location("Ha Noi","Cau Giay");
        List<Location> list = new ArrayList<>();
        list.add(location1);
        list.add(location2);
        list.add(location3);
        LocationDaoImp locationDaoImp =new LocationDaoImp();
        assertTrue(locationDaoImp.insertLocation(list));
    }
}