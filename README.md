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

(Add screenshots here)

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
