CREATE TABLE Favorite (
  fav_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  recipe_id INT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES User(user_id),
  FOREIGN KEY (recipe_id) REFERENCES Recipe(recipe_id),
  UNIQUE KEY unique_favorite (user_id, recipe_id)
);