# 🛒 Shopping Cart Application - SmartShop

A full-stack **E-Commerce Web Application** developed using **Java Servlets, JSP, JDBC, and MySQL**. This application allows users to browse products, add them to a shopping cart, and place orders. It also includes an **Admin Dashboard** to manage products efficiently.

---

##  Features

###  User Features

* User Registration & Login
* Browse available products
* Add products to cart
* Update or remove items from cart
* Checkout and place orders

### 🛠️ Admin Features

* Add new products
* Edit product details
* Delete products
* Manage product listings
* View orders

---

##  Tech Stack

### Frontend

* HTML
* CSS
* JSP (Java Server Pages)

### Backend

* Java Servlets
* JDBC

### Database

* MySQL

### Server

* Apache Tomcat

---

## 📂 Project Structure

```
Shopping_Cart_Application/
│
├── src/main/java/com/shop/
│   ├── controller/   # Servlets (Business Logic)
│   ├── dao/          # Database Operations
│   ├── model/        # Entity Classes
│   └── util/         # DB Connection
│
├── src/main/webapp/
│   ├── *.jsp         # UI Pages
│   ├── assets/       # CSS Files
│   └── WEB-INF/
│       └── web.xml   # Configuration
│
└── lib/
    └── mysql-connector.jar
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/Shopping_Cart_Application.git
```

### 2️⃣ Import Project

* Open **Eclipse IDE**
* Go to **File → Import → Existing Projects into Workspace**
* Select the project folder

### 3️⃣ Configure Database

* Create a MySQL database (e.g., `shopping_cart`)
* Import the required tables (users, products, orders)
* Update database credentials in:

```
DBConnection.java
```

### 4️⃣ Add MySQL Connector

* Add `mysql-connector-j` JAR to the project build path

### 5️⃣ Run Project

* Deploy project on **Apache Tomcat Server**
* Run the server
* Open browser:

```
http://localhost:8080/Shopping_Cart_Application/
```

---

## 🧩 Modules

* **User Module** – Handles login, registration, and shopping
* **Product Module** – Displays products
* **Cart Module** – Manages cart items
* **Order Module** – Handles checkout
* **Admin Module** – Product management

---

## 🔐 Default Admin Access

You can configure admin credentials directly in the database or backend.

---

## 📸 Screens (Optional)

* Home Page
* Product Listing
* Cart Page
* Admin Dashboard

Screenshots :
<img width="1919" height="865" alt="Screenshot 2026-02-20 032422" src="https://github.com/user-attachments/assets/2dee0db0-ea74-4bf6-8759-1f2ae61b805e" />


<img width="1917" height="873" alt="Screenshot 2026-02-20 032444" src="https://github.com/user-attachments/assets/57c28558-7817-499d-843c-401b51738442" />


<img width="1899" height="865" alt="Screenshot 2026-02-20 032613" src="https://github.com/user-attachments/assets/47a4227b-8555-4846-be7e-c7c3cdde1fc9" />


<img width="1915" height="867" alt="Screenshot 2026-02-20 032327" src="https://github.com/user-attachments/assets/8c899c8a-4c91-4b14-8142-571d5d01bb05" />


<img width="1919" height="867" alt="Screenshot 2026-02-20 032720" src="https://github.com/user-attachments/assets/e728778d-0b86-41ac-ac62-d4d3a4e022de" />


---

## 📊 UML Diagrams

<img width="362" height="743" alt="Class Diagram" src="https://github.com/user-attachments/assets/ad99ae04-f960-4f73-8f63-125bc9c7c413" />


<img width="576" height="414" alt="Sequence Diagram" src="https://github.com/user-attachments/assets/30070106-93f5-4387-abaa-66cba618eb5a" />


<img width="1481" height="183" alt="UseCase Diagram" src="https://github.com/user-attachments/assets/0b8edb89-746c-4d51-aa04-6442f478cfa8" />

---

## 💡 Future Enhancements

* Payment Gateway Integration
* Order Tracking System
* User Profile Management
* Search & Filter Products
* Responsive UI (Bootstrap/React)

---

## 🙌 Author

Developed by **Rajita Raundal**

---
