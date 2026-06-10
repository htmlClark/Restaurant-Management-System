package Database;
import java.sql.*;

public class DB_Connection {
    public static Connection getConnection()
    {
        Connection toConn = null;

        try
        {
            String url = "jdbc:mysql://localhost:3306/restaurant-management-system";
            String username = "root";
            String password = "";

            toConn = DriverManager.getConnection(url, username, password);
            System.out.println("Database-RMS Connected...");
        }
        catch(Exception e)
        {
            System.out.println("Connection Failed: "+e.getMessage());
        }
        return toConn;
    }
}
