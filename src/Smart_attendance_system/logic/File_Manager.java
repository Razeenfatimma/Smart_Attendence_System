
package Smart_attendance_system.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class File_Manager {
    private static final String URL = "jdbc:mysql://localhost:3306/attendance_db";
    private static final String USER = "root";
    private static final String PASS = "root123,,";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
