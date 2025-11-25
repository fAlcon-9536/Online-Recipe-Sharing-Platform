import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set up the connection parameters
            String url = "jdbc:mysql://localhost:3306/recipe_platform"; // Replace with your DB URL
            String username = "root"; // Replace with your MySQL username
            String password = "user1_rootsql"; // Replace with your MySQL password

            // Attempt to connect
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection successful!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }
    }
}
