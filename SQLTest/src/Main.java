import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // MySQL URL and credentials
            String url = "jdbc:mysql://localhost:3306/javaTestOne";
            String user = "rootatkali";
            String password = "rootwizz";

            // Establishing connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Perform database operations here

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

