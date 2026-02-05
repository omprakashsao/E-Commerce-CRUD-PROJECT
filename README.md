# ✅ E-Commerce Item Management REST API
This project is a Spring Boot-based RESTful backend application that provides APIs to manage items in an e-commerce-like system.
The application allows users or client applications to perform CRUD operations (Create, Read, Update, Delete) on items through REST APIs.
The project is designed to demonstrate backend development skills, API design, validation, and exception handling without using an external database by utilizing in-memory storage.

# What the Application Does
## The application manages item data, where each item contains:

- Unique ID
- Name
- Description
- Price
- Creation timestamp
- Users can:
- Add new items
- Fetch item details
- Retrieve all items
- Update item information
- Delete items
- All operations are performed through HTTP APIs.

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

## 7. Clean Project Structure

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







