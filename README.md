# Online-Recipe-Sharing-Platform
The platform will enable users to share their recipes, search and discover new recipes, and interact with other users through ratings and comments. Administrators will oversee user activities, manage recipe content, and maintain system settings.
# Online Recipe Sharing Platform

An interactive web application built using Java Servlets and hosted on Apache Tomcat 10.1. This platform enables users to share, discover, rate, and comment on recipes while providing administrators comprehensive control over user and content management through dedicated dashboards.

## Features

### User Types and Capabilities

- **Admin**
  - Manage user accounts: create, update, delete users.
  - Approve or reject user-submitted recipes.
  - Configure system-wide settings.
  - Monitor recipe statistics (submission trends, ratings, comments).
  - Real-time user activity monitoring.

- **User**
  - Share new recipes with detailed info and photos.
  - Search and filter to discover recipes.
  - Rate and comment on recipes.
  - Manage personal profile and update details.
  - View and manage own recipe sharing history.

### Dashboards

- **Admin Dashboard**
  - User Management table with add/edit/delete options.
  - Recipe Management with approval/rejection controls.
  - System Settings panel.
  - Interactive graphs for recipe and user analytics.
  - Live user activity feed.

- **User Dashboard**
  - My Recipes list with edit/delete capabilities.
  - Recipe discovery interface with search and filter.
  - Ratings and comments management.
  - Profile management form.
  - Recipe sharing history and status overview.

## Deployment on Apache Tomcat 10.1

### Prerequisites

- Java Development Kit (JDK) installed and `JAVA_HOME` environment variable set.
- Apache Tomcat 10.1 installed on the server or local machine.
- Database configured and accessible by the web application.

### Deployment Steps

1. **Build your project** into a WAR (Web Application Archive) file, e.g., `recipe-platform.war`.
2. **Start Apache Tomcat**:
   - Run the `startup.bat` (Windows) or `startup.sh` (Linux/macOS) script located in the Tomcat `bin` directory.
3. **Deploy the WAR file**:
   - Copy the WAR file to the `webapps` folder inside the Tomcat installation directory.
   - Alternatively, use the Tomcat Manager web application:
     - Access `http://localhost:8080/manager/html` in your browser.
     - Log in with admin credentials configured in `tomcat-users.xml`.
     - Use the "Deploy" section to upload your WAR file or deploy from the server path.
4. **Access your application**:
   - Navigate to `http://localhost:8080/recipe-platform` (or your WAR file context path) in your web browser.
5. **Monitor Logs and Status**:
   - Check Tomcat logs in the `logs` directory for deployment success and runtime status.
6. **Stopping and Restarting Tomcat**
   - Use `shutdown.bat` or `shutdown.sh` to stop.
   - Use `startup.bat` or `startup.sh` to restart Tomcat.

### Configuration Notes

- Ensure proper JDBC database connection strings and credentials are set in your application’s configuration files.
- Adjust Tomcat user roles in the `tomcat-users.xml` file to enable Manager access.
- For production environments, consider additional security setups and performance tuning.


## Usage

- Access the site via browser at your Tomcat server URL.
- Register or log in as a user or admin.
- Admins can manage content and users through their dashboard.
- Users can share, discover, rate, and comment on recipes freely.

## Contributing

- Fork the repository and create your feature branch.
- Commit your changes with descriptive messages.
- Submit pull requests for review and merging.
- Report issues for bugs or feature requests.



## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For support or inquiries, please contact: 004.ayush30@gmail.com

---

This README provides a comprehensive introduction and guides users and developers through installation, usage, and contribution for your Java Servlet-based Online Recipe Sharing Platform hosted on Apache Tomcat 10.1. Customize specific details such as repository URL, database setup, and contact info as needed.
