# 🌌 StarDistance API

StarDistance is a Spring Boot REST API that calculates the 3D distance between stars in space based on their coordinates.


## 🚀 Technologies
- Java 17
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Gradle

---

## 🧠 How it works

Each star is stored with a name and 3D coordinates `(x, y, z)`.
The distance between two stars is calculated using the **3D Euclidean distance**:

```

d = √[(x₂ − x₁)² + (y₂ − y₁)² + (z₂ − z₁)²]

```
Where:
- `(x₁, y₁, z₁)` is the position of the first star  
- `(x₂, y₂, z₂)` is the position of the second star  
- `d` is the distance between them

---

## 📡 API Endpoints

### ➕ Create a star
`POST /stars`

```json
{
  "name": "Sirius",
  "x": 8.6,
  "y": 1.2,
  "z": -3.1
}
````

---

### 📋 List all stars

`GET /stars`

---

### 📏 Calculate distance between two stars

`GET /stars/distance?fromStar=Sirius&toStar=Vega`

Example response:

```json
{
  "fromStar": "Sirius",
  "toStar": "Vega",
  "distance": 25.87
}
```

---

## ▶️ How to run

1. Clone the repository
2. Open in IntelliJ or VSCode
3. Run `StarDistanceApplication`
4. The API will be available at:

```
http://localhost:8080
```
