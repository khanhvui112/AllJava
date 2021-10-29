package fa.training.dao;

import fa.training.entity.Location;

import java.util.List;

/**
 * @author san vui
 * @create 19/10/2021 - 10:02 AM
 * @sanvankhanh@gmail.com
 */
public interface LocationDao {
    boolean insertLocation(List<Location> list);
}
