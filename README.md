Features

**1.	Category CRUD Operations:**
o	Create, Read, Update, and Delete categories.
o	Supports server-side pagination for listing categories.

**2.	Product CRUD Operations:**
o	Create, Read, Update, and Delete products.
o	Fetch a product with its associated category details.
o	Supports server-side pagination for listing products.

**3.	Category-Product Relationship:**
o	A Category can have multiple Products (One-to-Many).

**4.	Database Integration:**
o	Configured to work with MySQL or any relational database.
**Technologies Used**
•	Java 17
•	Spring Boot 3.x
•	Spring Data JPA
•	Hibernate
•	MySQL (can be replaced with any relational database)
•	Maven
•	Postman (for API testing)
**How to Run the Code**
**1. Prerequisites**
•	Java 17: Ensure Java is installed and the JAVA_HOME environment variable is configured.
•	Maven: Ensure Maven is installed and added to the system's PATH.
•	MySQL: Install MySQL or use any compatible relational database.
**2. Steps to Run the Application**
Clone the Repository:
git clone <repository-link>
cd machine-test
Set Up the Database:
o	Log into MySQL: 
o	**mysql -u root -p**
o	Create a new database: 
o	**CREATE DATABASE machine_test;**
o	Update the database configuration in the src/main/resources/application.properties file: 
o	spring.datasource.url=jdbc:mysql://localhost:3306/machine_test
o	spring.datasource.username=<your-username>
o	spring.datasource.password=<your-password>
o	spring.jpa.hibernate.ddl-auto=update
**5.	Build the Project:**
o	Use Maven to clean and build the project: 
o	mvn clean install
**6.	Run the Application:**
o	Start the Spring Boot application: 
o	mvn spring-boot:run
o	Alternatively, use the packaged JAR file: 
o	java -jar target/machine-test-0.0.1-SNAPSHOT.jar
**7.	Verify the Application:**
o	Access the application at http://localhost:8080.

