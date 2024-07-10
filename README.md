# MiniERPsystem
This App is a comprehensive enterprise resource planning (ERP) system designed to manage various aspects of a business, including product management, sales, and procurement. The application provides an intuitive interface for managing products, orders(sales and raw material orders), customers, and suppliers.

Features
Product Management
View Products: See a list of all products with details like name, description, and price.
Add Products: Add new products to the inventory.
Edit Products: Update existing product details.
Delete Products: Remove products from the inventory.
Sales Management
Orders Management: Create, view customer orders details(history , cart).
Customers Management: Create, view, update, and delete customers.
Procurement Management
Orders for Raw Materials: Create, view, update, and delete orders for raw materials.
Suppliers Management: Manage supplier information and view the materials each supplier provides.


========================================

Technologies Used
This application was built using a combination of powerful and modern technologies to ensure robustness, scalability, and ease of use. Below are the main technologies and frameworks utilized:

Database: Microsoft SQL Server

Microsoft SQL Server was chosen for its reliability, comprehensive data management capabilities, and robust performance. It provides the backbone for storing and managing all the data required by the application, including product details, orders, customers, suppliers, and more.
Backend: Java Spring Boot

The backend of the application is powered by Java Spring Boot, a versatile and comprehensive framework that simplifies the development of robust and scalable web applications. Spring Boot allows for the rapid creation of production-ready applications that can handle complex business logic and data interactions with ease.
Frontend: HTML and JavaScript

HTML: The structure and layout of the user interface are built using HTML, ensuring a semantic and accessible design.
JavaScript: JavaScript is used extensively for client-side logic and interaction. The fetch API is employed to make asynchronous requests to the backend, enabling dynamic data loading and updates without requiring full page reloads. This results in a smoother and more responsive user experience.




========================================


API Endpoints
Suppliers
GET /api/suppliers - Get all suppliers
POST /api/suppliers - Add a new supplier
PUT /api/suppliers/{id} - Update a supplier
DELETE /api/suppliers/{id} - Delete a supplier
Raw Materials
GET /api/supplierRawMaterials/bySupplier/{supplierID} - Get raw materials by supplier
Orders for Raw Materials
POST /api/rawMaterialOrders - Create a new order for raw materials
Customers
GET /api/customers - Get all customers
POST /api/customers - Add a new customer
PUT /api/customers/{id} - Update a customer
DELETE /api/customers/{id} - Delete a customer
Product Orders
POST /api/productOrders - Create a new product ord



========================================



Usage
Home Page
The home page provides navigation to different management sections:

Product Management: Manage all product-related operations.
Sales: Access orders and customer management.
Procurement Management: Manage raw material orders and supplier information.
Adding and Managing Orders
Navigate to the Orders section:
From the home page, choose the appropriate section for managing orders.

Create a New Order:
Fill out the order form with relevant details and submit.

View and Update Orders:
Review the list of existing orders and make necessary updates.

Managing Suppliers and Raw Materials
Navigate to the Suppliers section:
From the home page, go to Procurement Management and select Suppliers Management.

Add or Edit Suppliers:
Manage supplier information and view the materials they supply.

Create Orders for Raw Materials:
Select raw materials (based in the availability from the specific supplier) and quantities to create a new order for raw materials.
