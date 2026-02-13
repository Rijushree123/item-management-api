# Item Management API

A simple Item Management REST API built with Spring Boot for managing items.

🚀 Live API (optional)
https://item-management-api-abhg.onrender.com

You can test endpoints using Postman or curl — there is no frontend UI included.

## Features

- Add new items
- Get all items
- Get a single item by ID

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Jakarta Validation
- Maven
- (Optional) H2 / PostgreSQL, Docker

## API Endpoints

Base URL: https://item-management-api-abhg.onrender.com/items

1) Get All Items

GET /items

- Successful Response (200 OK) — returns a JSON array of items:

```json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 1200,
    "description": "High-end device",
    "quantity": 5,
    "category": "Electronics"
  }
]
```

- If no items exist the API returns 200 OK with a small message and an empty `items` array (see example):

```json
{
  "message": "No items found. Please add some items.",
  "items": []
}
```

2) Get Item by ID

GET /items/{id}

Example: `/items/1`

- Successful Response (200 OK)

```json
{
  "id": 1,
  "name": "Laptop",
  "price": 1200,
  "description": "High-end device",
  "quantity": 5,
  "category": "Electronics"
}
```

- If the ID is not found the API returns 404 Not Found with a message:

```json
"Item not found"
```

3) Create Item

POST /items

Example request body (JSON):

```json
{
  "name": "Phone",
  "price": 800,
  "description": "Android device",
  "quantity": 10,
  "category": "Electronics"
}
```

- Successful Response: 201 Created — returns the created item (with `id`):

```json
{
  "id": 2,
  "name": "Phone",
  "price": 800,
  "description": "Android device",
  "quantity": 10,
  "category": "Electronics"
}
```

## Using Postman

### Step 1: Open Postman
Download and open [Postman](https://www.postman.com/downloads/) or use the web version.

### Step 2: Test GET All Items

1. Click **New** → **Request** (or **+** tab)
2. Select method: **GET**
3. Enter URL: `http://localhost:8080/items` (for local testing)
4. Click **Send**
5. You should see a response with items or the "No items found" message

### Step 3: Test POST Create Item

1. Click **New** → **Request**
2. Select method: **POST**
3. Enter URL: `http://localhost:8080/items`
4. Go to the **Body** tab
5. Select **raw** and choose **JSON** from the dropdown
6. Paste this JSON:

```json
{
  "name": "Laptop",
  "price": 1200,
  "description": "High-end device",
  "quantity": 5,
  "category": "Electronics"
}
```

7. Click **Send**
8. You should get a **201 Created** response with the item including its `id`

### Step 4: Test GET Item by ID

1. Click **New** → **Request**
2. Select method: **GET**
3. Enter URL: `http://localhost:8080/items/1` (replace `1` with the item ID from Step 3)
4. Click **Send**
5. You should see the item details

## Using curl

Example curl to list items:

```bash
curl -X GET http://localhost:8080/items
```

Example curl to create an item:

```bash
curl -X POST http://localhost:8080/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","price":1200,"description":"High-end device","quantity":5,"category":"Electronics"}'
```

Example curl to get item by ID:

```bash
curl -X GET http://localhost:8080/items/1
```

## Local Setup

Clone the repo:

```bash
git clone https://github.com/your-username/item-management-api.git
cd item-management-api
```

Run locally with the bundled Maven wrapper (Windows PowerShell):

```powershell
.\mvnw spring-boot:run
```

Or build and run the JAR:

```powershell
.\mvnw clean package
java -jar target/item-0.0.1-SNAPSHOT.jar
```

Or build and run with Docker:

```bash
docker build -t item-api .
docker run -p 8080:8080 item-api
```

## Project Structure

src/
 ├── main/
 │   ├── java/com/manage/item
 │   │    ├── controller
 │   │    ├── service
 │   │    ├── model
 │   │    └── repository
 │   └── resources/
 │        ├── application.properties
 └── test/

## Contributing

Pull requests are welcome. Open issues for suggestions or bug reports.
