CREATE TABLE Comment (
  comment_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  recipe_id INT NOT NULL,
  text TEXT NOT NULL,
  rating INT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES User(user_id),
  FOREIGN KEY (recipe_id) REFERENCES Recipe(recipe_id)
);