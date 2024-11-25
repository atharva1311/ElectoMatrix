# **ElectoMatrix**  
A comprehensive election candidate management system built using **Java**, **Hibernate**, **Maven**, and **MySQL**.  

## **Overview**  
ElectoMatrix is designed to efficiently manage and analyze election-related data, including candidates and political parties. This system provides features like candidate filtering (by party, age, or gender) and CRUD operations, ensuring seamless data handling and scalability.  

---

## **Features**  
- **Candidate Management**:  
  - View all registered candidates.  
  - Filter candidates by party, age, and gender.  

- **Party Management**:  
  - View all political parties along with their candidates.  

- **CRUD Operations**:  
  - Add, update, delete, and retrieve candidates and parties.  

- **Menu-Driven Interface**:  
  - Easy-to-use command-line interface for navigation and operations.  

---

## **Tech Stack**  
- **Programming Language**: Java  
- **ORM Framework**: Hibernate  
- **Database**: MySQL  
- **Build Tool**: Maven  

---

## **Project Architecture**  
The project is structured into five layers for better maintainability and scalability:  
1. **Entity Layer**: Defines the `Candidate` and `Party` POJO classes.  
2. **DAO Layer**: Handles database interactions using Hibernate ORM.  
3. **Service Layer**: Contains business logic for operations.  
4. **Controller Layer**: Facilitates communication between the client and service layers.  
5. **Client Layer**: Contains the main method and menu-driven user interface.  

---

## **Setup Instructions**  

### **Prerequisites**  
1. Java JDK (8 or later)  
2. Apache Maven  
3. MySQL Server  
4. IDE (e.g., IntelliJ IDEA, Eclipse)  

### **Steps to Set Up the Project**  
1. **Clone the Repository**:  
   ```bash
   git clone https://github.com/yourusername/ElectoMatrix.git
   cd ElectoMatrix
### **Configure the Database**  
1. Create a MySQL database (e.g., `electomatrix_db`):  
   ```sql
   CREATE DATABASE electomatrix_db;
2.Update the hibernate.cfg.xml file with your database details:
```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/electomatrix_db</property>
        <property name="hibernate.connection.username">your-username</property>
        <property name="hibernate.connection.password">your-password</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
    </session-factory>
</hibernate-configuration>
```
3. Build the Project
   Use Maven to clean and build the project:
   ```bash
   mvn clean install
4. Run the Project
   Navigate to your project in your IDE, locate the main method in the client package, and run the application.

## **Usage**
Upon running the project, a menu-driven CLI will appear with the following options:
- View all candidates. 
- Filter candidates by party, age, or gender.  
- Display all parties. 
- Add, update, or delete candidate/party data.

  
   
   
