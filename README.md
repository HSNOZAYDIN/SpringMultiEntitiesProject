# Spring Boot Multi-Entity Project

Hi everyone! 
This is a backend project I built to practice my Spring Boot and Java skills. I wanted to understand how to manage different entities (like Student, Course, Employee) and connect them using a database.

I used **PostgreSQL** for the database and tried to implement clean coding practices like using DTOs.

##  What I Used
* **Java 17**
* **Spring Boot 3**
* **PostgreSQL** (Database)
* **Maven** (Dependency Management)
* **Lombok** (To avoid writing getters/setters manually)
* **Validation** (To check inputs)

##  What Does This Project Do?
In this project, I created REST APIs to handle data. Here is what I implemented:

* **Entity Relationships:** I connected tables using `@OneToMany`, `@ManyToOne`, etc. For example, a Student can have courses, or an Employee belongs to a Department.
* **DTO Pattern:** Instead of exposing the database entities directly, I used DTO classes (like `DtoStudentIU`) to make it safer.
* **CRUD Operations:** You can Add, List, Update, and Delete records for Students, Courses, Employees, etc.
* **Validation:** I added checks (like `@Email`, `@NotEmpty`) so we don't save bad data to the database.

##  How to Run It on Your Machine

1.  Clone this repo:
    ```bash
    git clone [https://github.com/huseyinoz/SpringMultiEntitiesProject.git](https://github.com/huseyinoz/SpringMultiEntitiesProject.git)
    ```

2.  Update the database settings:
    Open `src/main/resources/application.properties` and put your own PostgreSQL username and password.
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/YOUR_DB_NAME
    spring.datasource.username=postgres
    spring.datasource.password=your_password
    ```

3.  Run the project using Maven or your IDE (like STS or IntelliJ).

##  Note
I'm still learning and improving my coding skills. If you see any mistakes or have suggestions, feel free to let me know!
