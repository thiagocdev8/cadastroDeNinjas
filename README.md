Ninja Registration API – Spring Boot CRUD Project
A backend project developed for my Java class at Estácio University. This RESTful API allows full CRUD operations for managing ninja records in a forum-style application for Naruto fans.

📌 Project Purpose
This project was created as part of my academic learning in Java and Spring Boot. The goal was to build a simple and functional backend system that enables Create, Read, Update, and Delete operations on a list of ninjas.

🚀 Technologies Used
Spring Boot – Simplified setup and configuration for backend services

Spring Web – Enables the creation of REST endpoints

Spring Data JPA – Simplifies database access using ORM

Lombok – Reduces boilerplate code with annotations for getters, setters, constructors, etc.

🔧 Features
✅ Create new ninjas via POST

✅ List all ninjas with GET

✅ Update existing ninjas using PUT

✅ Delete ninjas with DELETE

✅ Clean mapping between DTO and Entity models


📬 API Endpoints
Method	Endpoint	Description
POST	/ninjas	Create a new ninja
GET	/ninjas	Get list of all ninjas
PUT	/ninjas/{id}	Update a ninja by ID
DELETE	/ninjas/{id}	Delete a ninja by ID

📁 Project Structure
cadastroDeNinjas/
├── controller/      # REST Controllers
├── service/         # Business logic
├── repository/      # JPA Repositories
├── model/           # Entity classes (Ninja, Missions)
├── dto/             # Data Transfer Objects
└── application.properties  # App configuration


🌱 Future Improvements
Add input validation using @Valid
Implement custom exception handling
Integrate Swagger for API documentation
Add unit and integration tests

🎓 About the Developer
This project was built as part of my studies in Java backend development using the Spring ecosystem. It helped me understand real-world concepts like layered architecture, RESTful API design, and best practices with DTOs and entities.

Feel free to fork, clone, or contribute!
⭐ If you liked this project, give it a star!




