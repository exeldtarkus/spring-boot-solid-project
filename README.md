# 🚀 spring-boot-solid-project

A clean and maintainable Spring Boot application template that follows **SOLID principles** and modular architecture. This project uses a custom implementation of **Criteria API** for flexible and type-safe query building, with a clear separation of concerns.

---

## 📂 Project Structure

```
src/main/java/com/example/spring_solid_criteria
│
├── common/                 # Common response wrapper and utilities
├── controllers/            # REST controllers (e.g. UserController)
├── dto/                    # DTOs: request, response, and params for filtering/pagination
│   ├── params/
│   ├── request/
│   └── response/
├── entity/                 # JPA entity classes (e.g. User.java)
├── exceptions/             # Custom exceptions and global exception handler
├── interfaces/             # Repository and service interface abstractions
├── repositories/           # Criteria-based query implementations
├── services/               # Business logic (e.g. UserService)
└── SpringSolidCriteriaApplication.java # Main entry point
```

---

## 🔧 Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA + Criteria API
- Lombok
- H2/PostgreSQL (DB agnostic)
- JUnit 5
- Custom exception handler
- RESTful API design

---

## 🧠 SOLID Principles Applied

- **S**: Single Responsibility – DTOs, services, and repositories are strictly separated  
- **O**: Open/Closed – Criteria query classes allow for flexible extension  
- **L**: Liskov Substitution – Interfaces enforce contract-based architecture  
- **I**: Interface Segregation – `IUserService`, `IUserRepository`, etc.  
- **D**: Dependency Inversion – Services depend on interfaces, not implementations  

---

## 🚀 Getting Started

### 🛠 Requirements
- Java 17+
- Maven 3.6+

### 🧪 Run the application

```bash
./mvnw spring-boot:run
```

### 🌐 Test the API

After starting the app, you can test endpoints like:
```
GET /api/v1/users
POST /api/v1/users
```

---

## 🧪 Test

```bash
./mvnw test
```

Unit tests are located in:

```
src/test/java/com/example/spring_solid_criteria
```

---

## 📄 License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for more information.

---

## 🙌 Contributing

Pull requests are welcome! Feel free to open issues or suggest improvements.

---

## ✍️ Author

Developed with ♥ by [Exel Tarkus]
