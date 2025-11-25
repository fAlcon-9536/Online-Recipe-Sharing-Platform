public class RecipeIngredient {
    private int recIngId;     // PK
    private int recipeId;     // FK
    private int ingredientId; // FK
    private int unitId;       // FK
    private double amount;

    public RecipeIngredient(int recIngId, int recipeId, int ingredientId, int unitId, double amount) {
        this.recIngId = recIngId;
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.unitId = unitId;
        this.amount = amount;
    }
    // Getters/setters...
}

