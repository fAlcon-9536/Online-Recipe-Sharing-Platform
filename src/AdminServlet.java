import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AdminServlet extends HttpServlet {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/recipe_platform"; // set your DB URL
    private final String jdbcUsername = "root"; // set your DB username
    private final String jdbcPassword = "user1_rootsql"; // set your DB password

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Admin Dashboard Loaded</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        String action = request.getParameter("action");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {

            if ("delete_user".equals(action)) {
                String userId = request.getParameter("user_id");
                String sql = "DELETE FROM User WHERE user_id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, Integer.parseInt(userId));
                    int rows = stmt.executeUpdate();
                    out.println("<h2>User " + userId + " deleted (" + rows + " rows affected).</h2>");
                }
            } else if ("update_user".equals(action)) {
                String userId = request.getParameter("user_id");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String sql = "UPDATE User SET name=?, email=? WHERE user_id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.setString(2, email);
                    stmt.setInt(3, Integer.parseInt(userId));
                    int rows = stmt.executeUpdate();
                    out.println("<h2>User " + userId + " updated (" + rows + " rows affected).</h2>");
                }
            } else if ("ban_user".equals(action)) {
                String userId = request.getParameter("user_id");
                String sql = "UPDATE User SET role='banned' WHERE user_id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, Integer.parseInt(userId));
                    int rows = stmt.executeUpdate();
                    out.println("<h2>User " + userId + " banned (" + rows + " rows affected).</h2>");
                }
            } else if ("delete_recipe".equals(action)) {
                String recipeId = request.getParameter("recipe_id");
                String sql = "DELETE FROM Recipe WHERE recipe_id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, Integer.parseInt(recipeId));
                    int rows = stmt.executeUpdate();
                    out.println("<h2>Recipe " + recipeId + " deleted (" + rows + " rows affected).</h2>");
                }
            } else if ("update_recipe".equals(action)) {
                String recipeId = request.getParameter("recipe_id");
                String title = request.getParameter("title");
                String status = request.getParameter("status");
                String sql = "UPDATE Recipe SET title=?, status=? WHERE recipe_id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, title);
                    stmt.setString(2, status);
                    stmt.setInt(3, Integer.parseInt(recipeId));
                    int rows = stmt.executeUpdate();
                    out.println("<h2>Recipe " + recipeId + " updated (" + rows + " rows affected).</h2>");
                }
            } else if ("delete_comment".equals(action)) {
                String commentId = request.getParameter("comment_id");
                String sql = "DELETE FROM Comment WHERE comment_id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, Integer.parseInt(commentId));
                    int rows = stmt.executeUpdate();
                    out.println("<h2>Comment " + commentId + " deleted (" + rows + " rows affected).</h2>");
                }
            } else {
                out.println("<h2>Unknown admin action.</h2>");
            }
        } catch (SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace(out);
        }
    }

    @Override
    public void init() throws ServletException {
        try {
            // Ensure JDBC driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
}
