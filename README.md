# DeFiStock Java
A hackathon project for decentralized finance in local commerce, built with Spring Boot and MySQL.

## Features
- Inventory funding: Customers fund items to trigger restocking.
- Voting: Customers vote on future stock with points.

## Setup
1. Install Java 17, Maven, and MySQL.
2. Create database: `CREATE DATABASE defistock_db;`
3. Update `application.properties` with MySQL credentials.
4. Run: `mvn clean install` then `mvn spring-boot:run`
5. Visit: `http://localhost:8080/dashboard`

## Demo Data
```sql
INSERT INTO inventory (id, item_name, quantity, retailer_id, funding_goal, current_funding)
VALUES (1, 'Soap', 50, 1, 100.0, 0.0), (2, 'Shampoo', 20, 1, 80.0, 0.0);
INSERT INTO vote (user_id, item_name, points_spent)
VALUES (1, 'Conditioner', 20.0), (1, 'Toothpaste', 15.0);