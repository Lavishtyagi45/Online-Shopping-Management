# Online Shopping Management System


## Overview

The Online Shopping Management System is a Java-based console application that simulates an online shopping platform. The system supports various user roles, including guests, customers, and administrators, providing a comprehensive interface for managing products, orders, and user accounts.

## Features

- **User Management**: Register, login, and manage user accounts.
- **Product Management**: Add, edit, delete, and display products.
- **Order Management**: Place, view, cancel, and track orders.
- **Shopping Cart**: Add, update, and remove products from the cart.
- **Search and Filter**: Search and filter products based on various criteria.
- **Payment Gateway**: Process payments for orders.

## Package Structure

The main components of the system are organized into the following classes:

- **Main**: Entry point of the application.
- **ProductManagement**: Manages product-related operations.
- **OrderManagement**: Handles order-related operations.
- **UserManagement**: Manages user registration, login, and details.
- **SearchAndFilter**: Provides search and filter functionality for products.
- **ShoppingCart**: Manages the shopping cart operations.
- **PaymentGateway**: Processes payments.
- **OrderTracking**: Tracks order statuses.

## Usage

### Running the Application

1. Ensure Java is installed on your system.
2. Compile the Java files.
3. Run the `Main` class to start the application.

### User Roles and Menus

#### Guest Menu

1. **Register**: Create a new user account.
2. **Login**: Log in to an existing user account.
3. **Exit**: Exit the application.

#### Customer Menu

1. **Place Order**: Place a new order.
2. **View Order History**: View past orders.
3. **Cancel Order**: Cancel an existing order.
4. **Search Products**: Search for products by keyword.
5. **Filter Products**: Filter products by price range.
6. **Add Product to Cart**: Add a product to the shopping cart.
7. **Update Cart**: Update the quantity of products in the cart.
8. **Remove Product from Cart**: Remove a product from the cart.
9. **Make Payment**: Process payment for an order.
10. **Track Order**: Track the status of an order.
11. **Logout**: Log out from the current user account.

#### Admin Menu

1. **Add Product**: Add a new product to the inventory.
2. **Edit Product**: Edit the details of an existing product.
3. **Delete Product**: Delete a product from the inventory.
4. **View All Orders**: View all orders in the system.
5. **Update Order Status**: Update the status of an order.
6. **Logout**: Log out from the current admin account.


### Use Case Description

The use case diagram illustrates the interactions between different users (Guest, Customer, Admin) and the online shopping management system. 


#### Actors:
1. **Guest**
2. **Customer**
3. **Admin**

#### Use Case Diagram
![useCaseDiagram](https://github.com/user-attachments/assets/cb85d8ac-d4f9-4d9b-881b-5fed3df69b5f)

#### Use Cases:

1. **Register**:
   - **Actor**: Guest
   - **Description**: Allows a guest to create a new user account.
   - **Steps**: 
     - Guest provides registration details (username, password, email).
     - System validates the information and creates a new user account.

2. **Login**:
   - **Actor**: Guest, Customer, Admin
   - **Description**: Allows users to log into their account.
   - **Steps**: 
     - User provides login credentials (username, password).
     - System verifies the credentials and grants access to the system.

3. **Logout**:
   - **Actor**: Customer, Admin
   - **Description**: Allows users to log out of their account.
   - **Steps**:
     - User requests to log out.
     - System ends the user session and returns to the login page.

4. **Place Order**:
   - **Actor**: Customer
   - **Description**: Allows a customer to place a new order.
   - **Steps**:
     - Customer selects products and adds them to the cart.
     - Customer proceeds to checkout, provides shipping details, and makes payment.
     - System processes the order and confirms the purchase.

5. **View Order**:
   - **Actor**: Customer
   - **Description**: Allows a customer to view their order history.
   - **Steps**:
     - Customer requests to view order history.
     - System displays the list of past orders.

6. **Cancel Order**:
   - **Actor**: Customer
   - **Description**: Allows a customer to cancel an existing order.
   - **Steps**:
     - Customer selects an order to cancel.
     - System processes the cancellation and updates the order status.

7. **View All Orders**:
   - **Actor**: Admin
   - **Description**: Allows an admin to view all orders in the system.
   - **Steps**:
     - Admin requests to view all orders.
     - System displays the list of all orders.

8. **Update Order Status**:
   - **Actor**: Admin
   - **Description**: Allows an admin to update the status of an order.
   - **Steps**:
     - Admin selects an order to update.
     - Admin provides the new status.
     - System updates the order status.

9. **Add Products**:
   - **Actor**: Admin
   - **Description**: Allows an admin to add new products to the inventory.
   - **Steps**:
     - Admin provides product details (name, price, quantity).
     - System adds the new product to the inventory.

10. **Edit Products**:
    - **Actor**: Admin
    - **Description**: Allows an admin to edit the details of existing products.
    - **Steps**:
      - Admin selects a product to edit.
      - Admin updates product details.
      - System saves the changes.

11. **Delete Products**:
    - **Actor**: Admin
    - **Description**: Allows an admin to delete products from the inventory.
    - **Steps**:
      - Admin selects a product to delete.
      - System removes the product from the inventory.

12. **Add Products to Cart**:
    - **Actor**: Customer
    - **Description**: Allows a customer to add products to their shopping cart.
    - **Steps**:
      - Customer selects a product and specifies the quantity.
      - System adds the product to the shopping cart.

13. **Update Cart**:
    - **Actor**: Customer
    - **Description**: Allows a customer to update the quantity of products in the cart.
    - **Steps**:
      - Customer selects a product in the cart and updates the quantity.
      - System updates the cart with the new quantity.

14. **Remove Products from Cart**:
    - **Actor**: Customer
    - **Description**: Allows a customer to remove products from their shopping cart.
    - **Steps**:
      - Customer selects a product to remove from the cart.
      - System removes the product from the cart.

15. **Make Payment**:
    - **Actor**: Customer
    - **Description**: Allows a customer to make a payment for an order.
    - **Steps**:
      - Customer selects a payment method and provides payment details.
      - System processes the payment and confirms the transaction.

16. **Search Products**:
    - **Actor**: Customer
    - **Description**: Allows a customer to search for products by keyword.
    - **Steps**:
      - Customer enters a keyword to search.
      - System displays the search results.

17. **Filter Products**:
    - **Actor**: Customer
    - **Description**: Allows a customer to filter products by price range.
    - **Steps**:
      - Customer specifies the price range.
      - System displays the filtered products.

18. **Check Order Status**:
    - **Actor**: Customer
    - **Description**: Allows a customer to check the status of an order.
    - **Steps**:
      - Customer selects an order to check status.
      - System displays the order status.

### Class Diagram Description

The class diagram provides a detailed view of the various classes in the online shopping management system, their attributes, methods, and relationships.

#### Classes and Their Attributes/Methods:

1. **Main**
   - **Attributes**:
     - `loggedInUser: User`
     - `orderManagement: OrderManagement`
     - `productManagement: ProductManagement`
     - `userManagement: UserManagement`
     - `searchAndFilter: SearchAndFilter`
     - `shoppingCart: ShoppingCart`
     - `paymentGateway: PaymentGateway`
     - `orderTracking: OrderTracking`
   - **Methods**:
     - `showAllProducts(): void`
     - `showAdminMenu(): void`
     - `addProduct(): void`
     - `editProduct(): void`
     - `deleteProduct(): void`
     - `showCustomerMenu(): void`
     - `addProductToCart(): void`
     - `updateCart(): void`
     - `removeProductFromCart(): void`
     - `viewOrderHistory(): void`
     - `placeOrder(): void`
     - `cancelOrder(): void`
     - `displayAllOrders(): void`
     - `updateOrderStatus(): void`
     - `trackOrder(): void`
     - `makePayment(): void`
     - `filterProducts(): void`
     - `searchProducts(): void`
     - `showGuestMenu(): void`
     - `registerUser(): void`
     - `loginUser(): void`
     - `logout(): void`
     - `exit(): void`

2. **ProductManagement**
   - **Methods**:
     - `getProducts(): List<Product>`
     - `addProduct(product: Product): void`
     - `getProductById(id: int): Product`
     - `deleteProduct(id: int): void`
     - `updateProduct(product: Product): void`
     - `generateProductId(): int`
     - `updateProductQuantity(id: int, quantity: int): void`

3. **OrderManagement**
   - **Methods**:
     - `placeOrder(order: Order): void`
     - `getOrdersByUserId(userId: int): List<Order>`
     - `getAllOrders(): List<Order>`
     - `generateOrderId(): int`
     - `cancelOrder(orderId: int, userId: int): void`

4. **UserManagement**
   - **Methods**:
     - `login(username: String, password: String): User`
     - `registerUser(user: User): boolean`
     - `generateUserId(): int`

5. **SearchAndFilter**
   - **Methods**:
     - `searchProducts(keyword: String): List<Product>`
     - `filterProducts(minPrice: double, maxPrice: double): List<Product>`
     - `setProducts(products: List<Product>): void`

6. **ShoppingCart**
   - **Methods**:
     - `addProductToCart(userId: int, product: Product, quantity: int): void`
     - `updateProductQuantity(userId: int, productId: int, quantity: int): boolean`
     - `removeProductFromCart(userId: int, productId: int): boolean`

7. **PaymentGateway**
   - **Methods**:
     - `processPayment(amount: double): boolean`

8. **OrderTracking**
   - **Methods**:
     - `getOrderStatus(orderId: int): String`
     - `updateOrderStatus(orderId: int, status: String): boolean`

9. **Product**
   - **Attributes**:
     - `id: int`
     - `name: String`
     - `price: double`
     - `quantity: int`
   - **Methods**:
     - `getId(): int`
     - `setId(id: int): void`
     - `getName(): String`
     - `setName(name: String): void`
     - `getPrice(): double`
     - `setPrice(price: double): void`
     - `getQuantity(): int`
     - `setQuantity(quantity: int): void`

10. **Order**
    - **Attributes**:
      - `id: int`
      - `userId: int`
      - `productId: int`
      - `quantity: int`
      - `total: double`
      - `status: String`
      - `address: String`
    - **Methods**:
      - `getId(): int`
      - `setId(id: int): void`
      - `getUserId(): int`
      - `setUserId(userId: int): void`
      - `getProductId(): int`
      - `setProductId(productId: int): void`
      - `getQuantity(): int`
      - `setQuantity(quantity: int): void`
      - `getTotal(): double`
      - `setTotal(total: double): void`
      - `getStatus(): String`
      - `setStatus(status: String): void`
      - `getAddress(): String`
      - `setAddress(address: String): void`

11. **User**
    - **Attributes**:
      - `id: int`
      - `username: String`
      - `password: String`
      - `email: String`
      - `isAdmin: boolean`
    - **Methods**:
      - `getId(): int`
      - `setId(id: int): void`
      - `getUsername(): String`
      - `setUsername(username: String): void`
      - `getPassword(): String`
      - `setPassword(password: String): void`
      - `getEmail(): String`
      - `setEmail(email: String): void`
      - `isAdmin(): boolean`
      - `setAdmin(isAdmin: boolean): void`

#### Class Diagram 
![ClassDiagram1](https://github.com/user-attachments/assets/1ef32453-facd-48fc-bccc-396aeada7ddf)
### Relationships:

- **Main** uses the following classes:
  - `OrderManagement`
  - `ProductManagement`
  - `UserManagement`
  - `SearchAndFilter`
  - `ShoppingCart`
  - `PaymentGateway`
  - `OrderTracking`
  - `User`

- **ShoppingCart** has methods that interact with `Product` and `User`.

- **OrderManagement** places and manages orders which involve `Order` and `User`.

- **UserManagement** handles user authentication and registration, interacting with `User`.

- **SearchAndFilter** provides search and filtering functionalities for `Product`.

- **PaymentGateway** processes payments, which involve payment transactions.

- **OrderTracking** tracks and updates the status of `Order`.

- **ProductManagement** manages product-related activities involving `Product`.

### Flow Chart
A flow chart outlines the sequence of steps and decisions in the system processes.

1. **User Registration/Login:**
   - Guest registers as a Customer.
   - Customer logs in using credentials.

2. **Product Management:**
   - Admin adds/edit/deletes Products.

3. **Shopping:**
   - Customer browses/Searches/Filter Products.
   - Customer adds selected Products to Cart.
   - Customer updates Cart (quantity adjustments).
   - Customer removes Products from Cart.

4. **Order Placement:**
   - Customer proceeds to Checkout.
   - Customer enters Shipping/Billing details.
   - Customer selects Payment method.

5. **Payment Processing:**
   - Payment Gateway processes Payment.
   - System records Payment details (Payment status).

6. **Order Processing:**
   - System generates Order with Order details (Order ID, date, status, total amount).
   - Customer views Order confirmation.
   - Admin manages Orders (views, updates status).

7. **Order Tracking:**
   - Customer tracks Order status (pending, shipped, delivered).

8. **Logout:**
   - Customer/Admin logs out of the system.

#### Sample Input/Output for Customers
[![Frame 1](https://github.com/user-attachments/assets/1c422c7b-56d5-485a-80ee-5efc04b61528)
](https://www.youtube.com/watch?v=YvrL3iKG6d0)

#### Bibliography

1. **"A Project Report On ONLINE SHOPPING SYSTEM"**:
   - This project report provides an in-depth analysis of an online shopping system. It covers aspects such as system planning, requirements analysis, system design, and more.
   - [Read the full report](https://arkajainuniversity.ac.in/naac/Criteria%201/1.3.4/1_3_4_DOCUMENTS/CSIT/AJU190398.pdf) ¹.

2. **"Online shopping management system" (PDF)**:
   - An academic paper discussing an online shopping management system. Although the snippet doesn't provide extensive details, you might find it useful.
   - [Access the PDF](https://www.academia.edu/118364383/Online_shopping_management_system) ².

3. **GitHub Repositories**:
   - Explore existing GitHub repositories related to online shopping systems. These repositories often contain code, documentation, and project examples.
   - [GitHub Topics: Online Shopping System](https://github.com/topics/online-shopping-system) ³.

4. **Project Proposal Template**:
   - If you're creating a project proposal, consider using a template specifically designed for an online shopping system.
   - [Online Shopping System Project Proposal Template](https://clickup.com/templates/project-proposal/online-shopping-system) ⁴.

5. **"Mini Project Report On ONLINE SHOPPING SYSTEM"**:
   - Another mini project report that investigates the business potential of e-commerce for small and medium-sized enterprises (SMEs).
   - [Read the report](https://www.academia.edu/35185477/Mini_Project_Report_On_ONLINE_SHOPPING_SYSTEM) ⁵.

## Conclusion

This README provides an overview of the Online Shopping Management System, its features, package structure, and usage instructions. For further details and implementation, refer to the source code and comments within each class.
