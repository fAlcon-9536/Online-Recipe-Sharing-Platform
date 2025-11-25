import java.util.Date;

public class User {
    private int userId; // PK
    private String name;
    private String email;
    private String password;
    private String role; // "user" or "admin"
    private Date createdAt;

    public User(int userId, String name, String email, String password, String role, Date createdAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }
    // Getters and setters...
    // e.g.,
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    // Other getters/setters omitted for brevity.
}
