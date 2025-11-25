import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class UserServlet extends HttpServlet {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/recipe_platform";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "user1_rootsql";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {

            if ("register".equals(action)) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String role = request.getParameter("role");

                String sql = "INSERT INTO User (name, email, password, role) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.setString(2, email);
                    stmt.setString(3, password); // Hash password in production!
                    stmt.setString(4, role);
                    int rows = stmt.executeUpdate();
                    if (rows > 0) {
                        // Store username in session
                        HttpSession session = request.getSession();
                        session.setAttribute("user_name", name);
                        // Redirect with success indicator
                        response.sendRedirect("index.jsp?msg=success");
                        return;
                    } else {
                        out.println("<h2>Registration failed.</h2>");
                    }
                }
            } else if ("login".equals(action)) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                String sql = "SELECT * FROM User WHERE email=? AND password=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, email);
                    stmt.setString(2, password); // Hash in production!
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        HttpSession session = request.getSession();
                        session.setAttribute("user_id", rs.getInt("user_id"));
                        session.setAttribute("user_name", rs.getString("name"));
                        response.sendRedirect("index.jsp");
                        return;
                    } else {
                        out.println("<h2>Invalid email or password.</h2>");
                    }
                }
            } else if ("delete_user".equals(action)) {
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
            } else {
                out.println("<h2>Unknown user action.</h2>");
            }

        } catch (SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace(out);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>UserServlet is running.</h1>");
    }
}
