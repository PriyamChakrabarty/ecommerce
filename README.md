# 🛒 E-Commerce REST API

A Spring Boot RESTful backend application for managing **Categories** and **Products**. This project demonstrates CRUD operations, pagination, sorting, validation, exception handling, OpenAPI (Swagger), Docker deployment, and cloud deployment on Render.

---

## 🚀 Tech Stack

* Java 21
* Spring Boot 3.4.5
* Spring Web
* Spring Data JPA
* H2 Database
* Maven
* ModelMapper
* Spring Validation
* SpringDoc OpenAPI (Swagger)
* Docker
* Render Cloud Deployment

---

# Project Features

* Category Management
* Product Management
* CRUD Operations
* Pagination
* Sorting
* Input Validation
* Global Exception Handling
* RESTful API Design
* Swagger Documentation
* Dockerized Deployment
* Cloud Deployment on Render

---

# Project Structure

```
src
 ├── controller
 ├── service
 ├── repositories
 ├── model
 ├── payload
 ├── exceptions
 ├── config
 └── resources
```

---

# Live Deployment

**Base URL**

```
https://ecommerce-my33.onrender.com
```

---

# Swagger Documentation

### Local

```
http://localhost:8080/swagger-ui/index.html
```

### Render

```
https://ecommerce-my33.onrender.com/swagger-ui/index.html
```

---

# OpenAPI JSON

### Local

```
http://localhost:8080/v3/api-docs
```

### Render

```
https://ecommerce-my33.onrender.com/v3/api-docs
```

---

# API Endpoints

## Category APIs

---

### Get All Categories

| Method | Endpoint                 |
| ------ | ------------------------ |
| GET    | `/api/public/categories` |

Query Parameters

| Parameter  | Description      |
| ---------- | ---------------- |
| pageNumber | Page Number      |
| pageSize   | Records Per Page |
| sortBy     | Sort Field       |
| sortOrder  | asc / desc       |

Example

```
GET /api/public/categories?pageNumber=0&pageSize=5&sortBy=categoryId&sortOrder=asc
```

---

### Create Category

| Method | Endpoint                 |
| ------ | ------------------------ |
| POST   | `/api/public/categories` |

Request Body

```json
{
  "categoryName": "Electronics"
}
```

---

### Update Category

| Method | Endpoint                      |
| ------ | ----------------------------- |
| PUT    | `/api/public/categories/{id}` |

Example

```
PUT /api/public/categories/1
```

Body

```json
{
  "categoryName": "Mobiles"
}
```

---

### Delete Category

| Method | Endpoint                     |
| ------ | ---------------------------- |
| DELETE | `/api/admin/categories/{id}` |

Example

```
DELETE /api/admin/categories/1
```

---

# Product APIs

---

### Add Product

| Method | Endpoint                                     |
| ------ | -------------------------------------------- |
| POST   | `/api/admin/categories/{categoryId}/product` |

Example

```
POST /api/admin/categories/1/product
```

Request Body

```json
{
  "productName": "Laptop",
  "image": "laptop.jpg",
  "description": "Gaming Laptop",
  "quantity": 10,
  "price": 85000,
  "discount": 5,
  "specialPrice": 80750
}
```

---

### Get All Products

| Method | Endpoint               |
| ------ | ---------------------- |
| GET    | `/api/public/products` |

Query Parameters

* pageNumber
* pageSize
* sortBy
* sortOrder

Example

```
GET /api/public/products?pageNumber=0&pageSize=5
```

---

### Get Products By Category

| Method | Endpoint                                       |
| ------ | ---------------------------------------------- |
| GET    | `/api/public/categories/{categoryId}/products` |

Example

```
GET /api/public/categories/1/products
```

---

### Search Product By Keyword

| Method | Endpoint                                 |
| ------ | ---------------------------------------- |
| GET    | `/api/public/products/keyword/{keyword}` |

Example

```
GET /api/public/products/keyword/laptop
```

---

### Update Product

| Method | Endpoint                          |
| ------ | --------------------------------- |
| PUT    | `/api/admin/products/{productId}` |

Example

```
PUT /api/admin/products/1
```

Request Body

```json
{
  "productName": "Laptop Pro",
  "image": "laptop.jpg",
  "description": "Updated Gaming Laptop",
  "quantity": 20,
  "price": 95000,
  "discount": 10,
  "specialPrice": 85500
}
```

---

### Delete Product

| Method | Endpoint                          |
| ------ | --------------------------------- |
| DELETE | `/api/admin/products/{productId}` |

Example

```
DELETE /api/admin/products/1
```

---

# Running Locally

Clone the repository

```bash
git clone https://github.com/PriyamChakrabarty/ecommerce.git
```

Move into the project

```bash
cd ecommerce
```

Run

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

---

# Docker

Build

```bash
docker build -t ecommerce-api .
```

Run

```bash
docker run -p 8080:8080 ecommerce-api
```

---

# Database

Current Database

* H2 In-Memory Database

Connection

```
jdbc:h2:mem:test
```

> **Note:** Since H2 is an in-memory database, data will be cleared whenever the application restarts. For production deployments, consider using PostgreSQL or MySQL.

---

# Future Improvements

* JWT Authentication
* Spring Security
* User Registration & Login
* Shopping Cart
* Order Management
* Image Upload
* PostgreSQL Database
* Role-Based Authorization
* Unit & Integration Testing
* CI/CD Pipeline

---

# Author

**Priyam Chakrabarty**

GitHub

https://github.com/PriyamChakrabarty

---

git
