<%@ page language="java" session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Recipe Platform - Share & Discover</title>
  <link rel="stylesheet" href="assets/css/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@700;500;400&family=Roboto:wght@400;500&family=Pacifico&display=swap" rel="stylesheet">
  <style>
    /* Visually attractive featured recipe section for landing page only */
    .featured-flex-row {
      display: flex;
      gap: 2.1em;
      flex-wrap: wrap;
      justify-content: center;
      margin-top: 1.1em;
    }
    .recipe-card {
      width: 220px;
      border-radius: 18px;
      box-shadow: 0 2px 10px rgba(227,93,106,0.15);
      background: #fff;
      overflow: hidden;
      text-align: center;
      padding-bottom: 1em;
      margin-bottom: 2.2em;
      transition: box-shadow 0.18s, transform 0.17s;
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    .recipe-card img {
      width: 220px;
      height: 140px;
      object-fit: cover;
      border-radius: 14px;
      background: #fff;
      display: block;
      margin: 0 auto;
      margin-top: 1em;
      box-shadow: 0 1px 7px #e35d6a1d;
      border-bottom: 1px solid #ffe0ed;
      transition: transform 0.18s;
    }
    .recipe-card:hover img {
      transform: scale(1.05);
      box-shadow: 0 4px 18px #e35d6a29;
    }
    .card-title {
      margin: 1.04em 0 0.7em 0;
      font-weight: 700;
      color: #c42b5c;
      font-size: 1.13em;
      font-family: 'Montserrat', sans-serif;
      letter-spacing: 0.14px;
    }
    .cta-row {
      display: flex;
      justify-content: center;
      gap: 2em;
      margin-top: 2.8em;
      margin-bottom: 0.5em;
    }
    @media (max-width: 900px) {
      .featured-flex-row { flex-direction: column; align-items: center; gap: 26px;}
      .recipe-card, .recipe-card img { width:95vw; max-width:320px; height: 160px;}
      .cta-row {gap:1em;}
    }
    @media (max-width: 600px) {
      .recipe-card, .recipe-card img { width:92vw; max-width:250px; height:120px;}
    }
  </style>
</head>
<body>
  <header>
    <%
      String userName = (String) session.getAttribute("user_name");
      String msg = request.getParameter("msg");
    %>
    <nav class="navbar">
      <div class="logo"><i class="fa-solid fa-bowl-food"></i> RecipePlatform</div>
      <ul class="nav-links">
        <li class="nav-box"><a href="dashboard.html"><i class="fa-solid fa-gauge-high"></i> Dashboard</a></li>
        <li class="nav-box"><a href="index.jsp"><i class="fa-solid fa-house"></i> Home</a></li>
        <li class="nav-box"><a href="submit_recipe.html"><i class="fa-solid fa-plus"></i> Add Recipe</a></li>
        <%
          if (userName == null) {
        %>
          <li class="nav-box"><a href="login.html"><i class="fa-solid fa-right-to-bracket"></i> Login</a></li>
          <li class="nav-box"><a href="signup.html"><i class="fa-solid fa-user-plus"></i> Sign Up</a></li>
          <li class="nav-box"><a href="recipe_list.html"><i class="fa-solid fa-utensils"></i> Browse Recipes</a></li>
        <%
          } else {
        %>
          <li class="nav-box profile-box" tabindex="0">
            <a href="#" style="display:flex;align-items:center;"><i class="fa-solid fa-user-circle"></i> <%= userName %> <i class="fa fa-caret-down"></i></a>
            <ul class="profile-dropdown">
              <li><a href="dashboard.html"><i class="fa-solid fa-gauge-high"></i> Dashboard</a></li>
              <li><a href="profile.html"><i class="fa-solid fa-user"></i> Profile</a></li>
              <li><a href="logout.jsp"><i class="fa-solid fa-arrow-right-from-bracket"></i> Logout</a></li>
            </ul>
          </li>
        <%
          }
        %>
      </ul>
    </nav>
  </header>
  <main>
    <%
      if ("success".equals(msg) && userName != null) {
    %>
      <div class="success-message">
        Registration successful! Welcome, <%= userName %>
      </div>
    <%
      }
      if (userName != null) {
    %>
      <div style="text-align:center;font-size:1.2em;margin-top:2em;color:#db497b;font-weight:700;">
        Welcome, <span style="color:#e35d6a;"><%= userName %></span>!
      </div>
    <% } %>
    <div class="hero-main">
      <lottie-player src="https://assets2.lottiefiles.com/packages/lf20_kdx6cani.json"
        background="transparent" speed="1" style="width:60px;height:60px;vertical-align:-10px;" loop autoplay></lottie-player>
      Discover, Share, and Enjoy Great Food
    </div>
    <div class="hero-sub">Join today to create, share, and save your favorite recipes!</div>
    <div class="cta-row">
      <% if (userName == null) { %>
        <a href="login.html" class="btn-cta">Login</a>
        <a href="signup.html" class="btn-cta">Sign Up</a>
        <a href="recipe_list.html" class="btn-cta">Browse Recipes</a>
      <% } else { %>
        <a href="dashboard.html" class="btn-cta">Go to Dashboard</a>
        <a href="recipe_list.html" class="btn-cta">Browse Recipes</a>
      <% } %>
    </div>
    <section class="recipes-section">
      <div class="recipes-title" style="margin-bottom:1em;text-align:center;">Featured Recipes</div>
      <div class="featured-flex-row">
        <div class="recipe-card">
          <img src="assets/images/Spaghetti Carbonara.jpg" alt="Spaghetti Carbonara">
          <div class="card-title">Spaghetti Carbonara</div>
        </div>
        <div class="recipe-card">
          <img src="assets/images/Classic Pav Bhaji.jpg" alt="Classic Pav Bhaji">
          <div class="card-title">Classic Pav Bhaji</div>
        </div>
        <div class="recipe-card">
          <img src="assets/images/French Quiche.jpg" alt="French Quiche">
          <div class="card-title">French Quiche</div>
        </div>
        <div class="recipe-card">
          <img src="assets/images/Pizza.jpg" alt="Margherita Pizza">
          <div class="card-title">Margherita Pizza</div>
        </div>
        <div class="recipe-card">
          <img src="assets/images/Banh Mi.jpg" alt="Banh Mi">
          <div class="card-title">Banh Mi Sandwich</div>
        </div>
        <div class="recipe-card">
          <img src="assets/images/Ramen.jpg" alt="Japanese Ramen">
          <div class="card-title">Japanese Ramen</div>
        </div>
        <!-- ...add more cards as you desire, up to your desired total... -->
      </div>
    </section>
  </main>
  <footer>
    <p>&copy; 2025 RecipePlatform</p>
  </footer>
</body>
</html>
