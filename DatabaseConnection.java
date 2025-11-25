import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/recipe_platform"; // replace with your DB URL
        String username = "root"; // replace with your username
        String password = "user1_rootsql"; // replace with your password
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
}
