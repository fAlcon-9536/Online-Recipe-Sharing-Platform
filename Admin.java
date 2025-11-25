import java.util.Date;

public class Admin extends User {
    public Admin(int userId, String name, String email, String password, Date createdAt) {
        super(userId, name, email, password, "admin", createdAt);
    }
    public void approveRecipe(Recipe recipe) {
        recipe.setStatus("approved");
    }
}

