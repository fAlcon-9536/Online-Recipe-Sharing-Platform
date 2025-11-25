import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,   // 1MB
    maxFileSize = 1024 * 1024 * 5,     // 5MB
    maxRequestSize = 1024 * 1024 * 10  // 10MB
)
public class RecipeServlet extends HttpServlet {

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

            if ("submit".equals(action)) {
                // Recipe details
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String instructions = request.getParameter("instructions");
                String status = request.getParameter("status");

                // 1. Get user_id from session (must be set during login)
                HttpSession session = request.getSession(false);
                int userId = (session != null && session.getAttribute("user_id") != null)
                    ? (int) session.getAttribute("user_id") : 0;

                // Debug print to console/log
                System.out.println("DEBUG user_id from session: " + userId);

                // 2. Handle optional recipe photo upload (not stored in DB in this example)
                Part photoPart = request.getPart("photo");
                String photoFileName = (photoPart != null && photoPart.getSize() > 0)
                        ? photoPart.getSubmittedFileName()
                        : null;
                // Optionally handle file saving using photoPart.getInputStream()

                // 3. Insert Recipe, WITH user_id
                String sql = "INSERT INTO Recipe (title, description, instructions, status, user_id) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, title);
                    stmt.setString(2, description);
                    stmt.setString(3, instructions);
                    stmt.setString(4, status);
                    stmt.setInt(5, userId);
                    int rows = stmt.executeUpdate();
                    out.println("<h2>Recipe submitted successfully (" + rows + " rows affected).</h2>");
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

            } else if ("delete_recipe".equals(action)) {
                String recipeId = request.getParameter("recipe_id");
                String sql = "DELETE FROM Recipe WHERE recipe_id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, Integer.parseInt(recipeId));
                    int rows = stmt.executeUpdate();
                    out.println("<h2>Recipe " + recipeId + " deleted (" + rows + " rows affected).</h2>");
                }

            } else {
                out.println("<h2>Unknown recipe action: " + action + "</h2>");
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
        out.println("<h1>RecipeServlet is running.</h1>");
    }
}
