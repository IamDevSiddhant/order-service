# Spring Boot Microservices Project

### **Order Service & Order Polling Service**
This project consists of two microservices: `Order Service` and `Order Polling Service`, implementing the **Transactional Outbox Design Pattern** to ensure reliable message delivery in a distributed system.

---

## Project Architecture


- **Order Service**: Handles order creation, processing, and storage.
- **Order Polling Service**: Polls the outbox table for events and processes them asynchronously.

Both services use a shared **outbox table** to manage reliable event propagation across microservices.

---

## 🛠️ **Technologies Used**

- **Java 17**
- **Spring Boot 3.1.8**
- **Spring Cloud Dependencies 2022.0.4**
- **Spring Data JPA**
- **Hibernate**
- **MySQL** (as the database)
- **Kafka** (for event processing)
- **Docker** (for containerization)

---

## ⚙️ **Order Service**

The `Order Service` is responsible for handling order creation, storage, and publishing events to the outbox. Key features:

- **Order Creation**: Handles customer orders and stores them in the database.
- **Transactional Outbox**: Ensures that every order event is reliably published by first persisting it in the outbox.

### Endpoints:

| HTTP Method | Endpoint        | Description               |
|-------------|-----------------|---------------------------|
| `POST`      | `/orders/v1`    | Create a new order         |

### Example Request (Create Order):

```json

{
  "customerId": "123",
  "productName": "Laptop",
  "productType": "Electronics",
  "price": 1500.00,
  "quantity": 2
}

```

### Key Sections:
- **Project Overview**
- **Architecture Diagram** (optional, if you have a diagram, include a link)
- **Technologies Used**
- **Service Descriptions**
  - Order Service
  - Order Polling Service
- **Endpoints**
- **Database Schema**
- **Running Instructions**
- **Transactional Outbox Design Paradigm**
- **License and Author Info**

## 🏃 **Running the Service**

Follow these steps to run the **Order Polling Service**:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/order-polling-service.git
