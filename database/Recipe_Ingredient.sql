CREATE TABLE Recipe_Ingredient (
  rec_ing_id INT AUTO_INCREMENT PRIMARY KEY,
  recipe_id INT NOT NULL,
  ingredient_id INT NOT NULL,
  unit_id INT NOT NULL,
  amount DECIMAL(8,2) NOT NULL,
  FOREIGN KEY (recipe_id) REFERENCES Recipe(recipe_id),
  FOREIGN KEY (ingredient_id) REFERENCES Ingredient(ingredient_id),
  FOREIGN KEY (unit_id) REFERENCES Unit(unit_id),
  UNIQUE KEY unique_recipe_ingredient (recipe_id, ingredient_id, unit_id)
);