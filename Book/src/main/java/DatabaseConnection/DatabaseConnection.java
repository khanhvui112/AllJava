package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author san vui
 * @create 09/09/2021 - 16:13
 * @sanvankhanh@gmail.com
 */
public class DatabaseConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
//        protocol: vendor: database connection properties
        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=FPT;",
                "sa",
                "23102000");
    }
}
