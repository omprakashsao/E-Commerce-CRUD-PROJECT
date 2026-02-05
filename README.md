# ✅ E-Commerce Item Management REST API
This project is a Spring Boot-based RESTful backend application that provides APIs to manage items in an e-commerce-like system.
The application allows users or client applications to perform CRUD operations (Create, Read, Update, Delete) on items through REST APIs.
The project is designed to demonstrate backend development skills, API design, validation, and exception handling without using an external database by utilizing in-memory storage.

# What the Application Does
## The application manages item data, where each item contains:



## 📦 Item Fields & Supported Operations

![Unique ID](https://img.shields.io/badge/Unique%20ID-blue)
![Name](https://img.shields.io/badge/Name-green)
![Description](https://img.shields.io/badge/Description-orange)
![Price](https://img.shields.io/badge/Price-red)
![Creation Timestamp](https://img.shields.io/badge/Creation%20Timestamp-purple)

![Add Item](https://img.shields.io/badge/Add%20Items-success)
![Fetch Item](https://img.shields.io/badge/Fetch%20Items-blue)
![Retrieve All](https://img.shields.io/badge/Retrieve%20All-yellow)
![Update Item](https://img.shields.io/badge/Update%20Item-orange)
![Delete Item](https://img.shields.io/badge/Delete%20Item-red)
![HTTP APIs](https://img.shields.io/badge/HTTP%20REST%20APIs-lightgrey)


# 🚀 Key Features Implemented

## 1. RESTful API Design
### APIs follow REST principles using HTTP methods:
   
- Operation	    Method
- Create item	  POST
- Fetch item	  GET
- Update item	  PUT
- Delete item	  DELETE

## 2. In-Memory Storage

- Items are stored using:
- ArrayList<Item>
- instead of a database.
- This keeps the project simple and fast for demonstration purposes.
- Note: Data resets when application restarts.

## 3. Input Validation

- User inputs are validated using annotations:
- Item name required
- Description required
- Price must be positive
- Invalid data returns structured error responses.

## 4. Exception Handling

- Global exception handling ensures:
- Item not found errors handled
- Validation errors returned properly
- Clean error responses sent to client

## 5. Service Layer Architecture

- The project uses:
- Interface + Implementation pattern
- to separate business logic from controllers.
- This improves scalability and maintainability.

## 6. Swagger API Documentation

### Swagger UI automatically documents APIs and allows testing APIs directly from browser.

<p align="center">
  <img src="asset/open-api-definition.png" width="500" alt="Dashboard Screenshot"/>
</p>

## 7. Clean Project Structure

```
e-commerce
│
├── src/main/java/com.omps.e_commerce
│   ├── controller
│   │    └── ItemController
│   │
│   ├── exception
│   │    ├── GlobalExceptionHandler
│   │    └── ItemNotFoundException
│   │
│   ├── model
│   │    ├── Item
│   │    └── CustomInfoError
│   │
│   ├── repository
│   │    └── ItemRepository
│   │
│   ├── service
│   │    ├── ItemService
│   │    └── ItemServiceImpl
│   │
│   └── ECommerceApplication
│
└── resources
    └── application.properties
```

## 📥 How to Download & Run the Application

Follow the steps below to run the project locally.

---

### ✅ 1. Install Java Development Kit (JDK 21)

Download and install **Java JDK 21** from the official Oracle website:

https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html

After installation, verify Java installation:

```bash
java -version
```

---

### ✅ 2. Install an IDE

You can use any Java IDE. Recommended options:

**IntelliJ IDEA**  
https://www.jetbrains.com/idea/download/?section=windows

OR

**Spring Tool Suite (STS)**  
https://spring.io/tools#eclipse

---

### ✅ 3. Clone the Repository

Clone the project from GitHub:

```bash
git clone https://github.com/omprakashsao/E-Commerce-CRUD-PROJECT.git
```

Move into the project directory:

```bash
cd E-Commerce-CRUD-PROJECT
```

---

### ✅ 4. Run the Project

Run using one of the following methods:

**Option A — IDE**
Open the project in your IDE and run:

```
ECommerceApplication.java
```

**Option B — Maven Command**
```bash
mvn spring-boot:run
```

---

### ✅ 5. Application Base URL

Once running, application will be available at:

```
http://localhost:8081
```

Base API path:

```
http://localhost:8081/v1/api/items
```

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|---------|---------|------------|
| POST | `/add` | Add new item |
| GET | `/get/{id}` | Get item by ID |
| GET | `/get/all` | Get all items |
| PUT | `/update/{id}` | Update item |
| DELETE | `/delete/{id}` | Delete item |

---

## 📌 API Endpoints and Usage

Base URL:

```
http://localhost:8081/v1/api/items
```

Below are the available API operations.

---

### ➕ Add Item

**Endpoint**
```
POST /add
```

**Description**
Creates a new item and stores it in memory.

**Request Body Example**
```json
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 75000
}
```

**Response**
Returns saved item with generated ID and timestamp.

---

### 📖 Get Item by ID

**Endpoint**
```
GET /get/{id}
```

**Description**
Fetches item details using its unique ID.

**Example**
```
GET /get/1
```

**Response**
Returns item if found, otherwise returns 404 error.

---

### 📚 Get All Items

**Endpoint**
```
GET /get/all
```

**Description**
Returns list of all stored items.

**Response**
List of items currently stored in memory.

---

### 📝 Update Item

**Endpoint**
```
PUT /update/{id}
```

**Description**
Updates an existing item.

**Example**
```
PUT /update/1
```

**Request Body**
```json
{
  "name": "Updated Laptop",
  "description": "Updated description",
  "price": 80000
}
```

**Response**
Returns updated item.

---

### 🗑 Delete Item

**Endpoint**
```
DELETE /delete/{id}
```

**Description**
Deletes an item using its ID.

**Example**
```
DELETE /delete/1
```

**Response**
Returns success message if deleted.

---

## ⚙ Important Implementation Details

### 1. In-Memory Storage
Items are stored using:

```java
ArrayList<Item>
```

No database is used, so data resets after application restart.

---

### 2. Automatic ID Generation
Each item receives a unique ID automatically when created.

---

### 3. Input Validation
Requests are validated using annotations such as:

- `@NotBlank`
- `@NotNull`
- `@Positive`

Invalid inputs return validation errors.

---

### 4. Global Exception Handling
Application uses a global exception handler to return structured error responses.

Example:
```json
{
  "status": "404",
  "message": "Item not found",
  "date": "timestamp"
}
```

---

### 5. Layered Architecture
Application follows clean architecture:

```
Controller → Service → Repository
```

This keeps business logic separated and maintainable.

---

### 6. Swagger Documentation
Swagger UI allows API testing from browser:

```
http://localhost:8081/swagger-ui.html
```

---

### 7. Service Interface Pattern
Business logic is defined via service interface and implementation for better scalability.

---

## 🧪 Testing APIs
APIs can be tested using:

- Swagger UI
- Postman
- Curl
- Frontend applications

---

## ⚠ Exception Handling & Validation

The application implements custom exception handling and input validation to ensure clean and meaningful API responses.

---

### 📌 Custom Exception: ItemNotFoundException

When an item is requested or deleted using an ID that does not exist, the system throws a custom exception:

```
ItemNotFoundException
```

This exception is handled globally using:

```
GlobalExceptionHandler
```

Example scenario:

```
GET /get/100
```

If item ID 100 does not exist, the response will be:

```json
{
  "status": "404",
  "message": "Item not found with id: 100",
  "date": "timestamp"
}
```

This prevents application crashes and returns user-friendly error messages.

---

### ✅ Request Validation Rules

The application validates incoming request data before processing.

Validation rules applied:

| Field | Rule |
|------|------|
| name | Required and cannot be empty |
| description | Required and cannot be empty |
| price | Required |
| price | Must be positive value |

Validation annotations used:

```java
@NotBlank
@NotNull
@Positive
```

---

### ❌ Example: Invalid Request Body

If client sends invalid request:

```json
{
  "name": "",
  "description": "",
  "price": -10
}
```

The API response will be:

```json
{
  "name": "Item name is required",
  "description": "Item description is required",
  "price": "Price must be positive"
}
```

---

### 📌 Benefits of Validation

- Prevents incorrect data storage
- Improves API reliability
- Provides meaningful feedback to client
- Ensures data consistency

---

### 🔄 Error Handling Flow

```
Invalid Request
      ↓
Validation Fails
      ↓
Exception Thrown
      ↓
GlobalExceptionHandler Handles
      ↓
Proper Error Response Returned
```

---

## 🛡 Result

All errors are handled gracefully without crashing the application, ensuring robust API behavior.



# ✅ Technical Implementation Highlights

- Spring Boot REST API
- Validation using Jakarta Validation
- Global exception handling

- Layered architecture
- Interface-based service layer
- Swagger OpenAPI integration
- Lombok usage to reduce boilerplate code

# ✅ Real-World Use Case

- The application simulates backend services used in:
- E-commerce platforms
- Inventory management systems
- Product catalog systems
- Online marketplaces

# ✅ Limitations (Current Scope)

- Since this is a demo project:
- No database integration
- No authentication
- No pagination/filtering
- Data lost on restart

# 📦 Future Enhancements

## Possible upgrades:

- Database integration
- Authentication & authorization
- Pagination and filtering
- Caching
- Docker deployment
- Cloud deployment







