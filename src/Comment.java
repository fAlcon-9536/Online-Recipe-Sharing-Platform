import java.util.Date;

public class Comment {
    private int commentId; // PK
    private int userId;    // FK
    private int recipeId;  // FK
    private String text;
    private int rating;
    private Date createdAt;

    public Comment(int commentId, int userId, int recipeId, String text, int rating, Date createdAt) {
        this.commentId = commentId;
        this.userId = userId;
        this.recipeId = recipeId;
        this.text = text;
        this.rating = rating;
        this.createdAt = createdAt;
    }
    // Getters/setters...
}

