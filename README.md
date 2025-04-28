# **📦 Features of E-commerce REST API (Spring Boot Backend)**
> **Product Management (CRUD)**

- Add new products with images.

* Update existing product details and images.

+ Delete products by ID.

- Retrieve product list and individual product details by ID.

> **Image Handling**

- Upload and store product images using MultipartFile.

+ Serve product images through API endpoints.

> **Search Products**

- Search products dynamically by keyword using REST /products/search?keyword=....

> **Error Handling**

- Proper HTTP status codes (200 OK, 404 Not Found, 500 Internal Server Error).

* Exception handling for file uploads and missing resources.

+ Cross-Origin Resource Sharing (CORS)

- Configured for React Frontend at http://localhost:5173/.

> **Technology Stack**

- Spring Boot

* REST API

+ Java

* Spring data jpa 

- Maven

* Multipart File Upload

+ Eclipse IDE

# **📋 Bonus: Example API Endpoints for README.md**

1. GET    /api/products             → Fetch all products
2. GET    /api/products/{id}         → Get product by ID
3. GET    /api/products/{id}/image   → Fetch product image
4. POST   /api/products              → Add a new product (with image)
5. PUT    /api/products/{id}         → Update product (with new image)
6. DELETE /api/products/{id}         → Delete product
7. GET    /api/products/search?keyword=shoes  → Search products









