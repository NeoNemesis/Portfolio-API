# Portfolio API

A RESTful API for managing portfolio data, including projects, blog posts, and contact information. Built with Spring Boot, JPA, and Spring Security.

## Technologies

- Java 17
- Spring Boot 3.4.3
- Spring Data JPA
- Spring Security
- H2 Database (for development)

## Features

- **Project Management**: CRUD operations for portfolio projects
- **Spring Boot Project Filter**: Special endpoint to display projects built with Spring Boot
- **Blog Management**: Store and display blog posts
- **Contact Information**: Store and display contact details
- **Security**: Basic authentication

## API Endpoints

### Projects
- `GET /api/projects` - Retrieve all projects
- `GET /api/projects/{id}` - Retrieve a specific project
- `POST /api/projects` - Create a new project
- `PUT /api/projects/{id}` - Update a project
- `DELETE /api/projects/{id}` - Delete a project
- `GET /api/projects/spring-boot` - Retrieve all Spring Boot projects

### Blog Posts
- `GET /api/blogposts` - Retrieve all blog posts
- `GET /api/blogposts/{id}` - Retrieve a specific blog post
- `POST /api/blogposts` - Create a new blog post
- `PUT /api/blogposts/{id}` - Update a blog post
- `DELETE /api/blogposts/{id}` - Delete a blog post

### Contact Information
- `GET /api/contact` - Retrieve all contact information
- `GET /api/contact/{id}` - Retrieve specific contact information
- `POST /api/contact` - Create new contact information
- `PUT /api/contact/{id}` - Update contact information
- `DELETE /api/contact/{id}` - Delete contact information

## Installation and Running

1. Clone the repository
   ```
   git clone https://github.com/yourusername/portfolio-api.git
   ```

2. Build the project
   ```
   cd portfolio-api
   mvn clean install
   ```

3. Run the application
   ```
   java -jar target/portfolio-api-0.0.1-SNAPSHOT.jar
   ```

4. Access the API
   ```
   http://localhost:8080/api/projects
   ```
   Use the username "victor" and password "password" for authentication.

## Testing with cURL

You can test the API using cURL:

```bash
# Get all projects
curl -X GET http://localhost:8080/api/projects -u victor:password

# Create a new project
curl -X POST http://localhost:8080/api/projects -H "Content-Type: application/json" -u victor:password -d "{\"title\":\"Activity Tracker GUI\",\"description\":\"A Java application that displays activity statistics using Swing.\",\"technologies\":\"Java, Swing, JPA\",\"githubLink\":\"https://github.com/username/activity-tracker-gui\",\"springBoot\":false}"

# Get Spring Boot projects
curl -X GET http://localhost:8080/api/projects/spring-boot -u victor:password
```

## Future Improvements

- Implement JWT for better security
- Add filtering and pagination
- Migrate to a production database like MySQL or PostgreSQL
- Add more test cases
- Implement OpenAPI/Swagger documentation

## Project Structure

```
src/main/java/com/victor/vilches/portfolio_api/
├── entity/
│   ├── Project.java
│   ├── BlogPost.java
│   └── ContactInfo.java
├── repository/
│   ├── ProjectRepository.java
│   ├── BlogPostRepository.java
│   └── ContactInfoRepository.java
├── controller/
│   └── PortfolioController.java
├── config/
│   └── SecurityConfig.java
└── PortfolioApiApplication.java
```

## About This Project

This project was developed as a demonstration of my backend development skills using Spring Boot. It showcases my understanding of RESTful API design, data persistence with JPA, and securing endpoints with Spring Security.

The API is designed to serve as the backend for a portfolio website, allowing for dynamic management of project information, blog content, and contact details.
