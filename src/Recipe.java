import java.util.Date;

public class Recipe {
    private int recipeId; // PK
    private int userId;   // FK
    private String title;
    private String description;
    private String instructions;
    private String photoUrl;
    private String status; // e.g. "pending", "approved"
    private Date createdAt;

    public Recipe(int recipeId, int userId, String title, String description, String instructions,
                  String photoUrl, String status, Date createdAt) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.instructions = instructions;
        this.photoUrl = photoUrl;
        this.status = status;
        this.createdAt = createdAt;
    }
    // Getters and setters...

    public void setStatus(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
    }
}
