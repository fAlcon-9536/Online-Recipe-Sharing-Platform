import java.util.Date;

public class Favorite {
    private int favId;     // PK
    private int userId;    // FK
    private int recipeId;  // FK
    private Date createdAt;

    public Favorite(int favId, int userId, int recipeId, Date createdAt) {
        this.favId = favId;
        this.userId = userId;
        this.recipeId = recipeId;
        this.createdAt = createdAt;
    }
    // Getters/setters...
}

