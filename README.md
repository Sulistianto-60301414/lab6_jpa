# Lab 6: Spring Boot JPA E-commerce

A simple e-commerce application built with Spring Boot and JPA for managing products.

## What This Does
- Manages digital products (e-books, software)
- Manages physical products (keyboards, mouse)
- Stores data in H2 database
- Provides REST API endpoints

## How to Run
1. Clone the repo
2. Run `mvn spring-boot:run`
3. Go to `http://localhost:8080`

## API Endpoints
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get one product
- `POST /api/products/digital` - Create digital product
- `POST /api/products/physical` - Create physical product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

## Example Request
```json
POST /api/products/digital
{
  "name": "Java E-book",
  "price": 15.99,
  "category": "Digital",
  "downloadLink": "https://example.com/book.pdf"
}
```

## Technologies
- Spring Boot 3.5.6
- Spring Data JPA
- H2 Database
- Maven
- Java 17

## Database
Access H2 console at: `http://localhost:8080/h2-console`
- URL: `jdbc:h2:mem:ecommercedb`
- Username: `sa`
- Password: (empty)

---
**Student:** Sulistianto Pratomo  
**Lab 6 - JPA Assignment**
