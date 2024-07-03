# Cat Image API

This project is a Spring Boot REST API that provides cat images based on various criteria.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

- Java JDK 17
- Maven
- Spring Boot
- Docker
- Angular CLI 17

### Clone the repository:
```bash
git clone https://github.com/oguzcihan/cataasdemo-app.git
```

### Installing For Backend

A step by step series of examples that tell you how to get a development environment running:

1. **Move into the project directory:**
```bash
cd cat-aas-demo
```
2. **Docker compose up:**
```bash
docker compose up -d
```
3. **Build the project:**
```bash
mvn clean install
mvn spring-boot:run
```
4.**Explore API Documentation:**

Additionally, you can explore the API documentation at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) when the application is running.



### Installing For Frontend

1. **Move into the project directory:**
```bash
cd cat-frontend
```
2. **Install Angular:**
```bash
npm install -g @angular/cli@17
Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy RemoteSigned
```
3. **Build and Install the project:**
```bash
npm install
```
4. **Run the project:**
```bash
ng serve --port 8081
```
5. **Localhost Link**

   http://localhost:8081/

### PGAdmin and Database Login

PGAdmin can be accessed at http://localhost:5050/

 * Register => Server
 * ### Connection
 * Host name/address: postgres
 * Port: 5432
 * Username: postgres
 * Password: postgres
 * Database Name: cat-app-cihan
 * Table Name: cat_images


