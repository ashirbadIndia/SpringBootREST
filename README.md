# SpringBootREST
Write a server using Java Stack(SpringBoot) and write APIs of the create, update, delete, fetch list and fetch details of the employee.

  
Authentication Method: Header-based authentication with client id and client secret
  
  
1. Create Employee  
2. Fetch all Employees  
3. Fetch Employee details  
4. update Employee  
5. remove Employee  
  
  
to run the app
  
```bash
mvn spring-boot:run
```
or
```bash
./mvnw spring-boot:run
```
  
APIs
  
GET  
http://localhost:8080/api/v1/employees/
  
GET  
http://localhost:8080/api/v1/employees/{id}
  
POST  
http://localhost:8080/api/v1/employees/
  
Body
```json
{
            "employeeId": "EKA130",
            "firstName": "Ashirbad",
            "lastName": "Behera",
            "email": "ashirbad.behera@em.com",
            "jobTitle": "Software Developer",
            "department": "Engineering"
}
```
  
PUT   
http://localhost:8080/api/v1/employees/{id}  

Body
```json
{
            "employeeId": "EKA130",
            "firstName": "Ashirbad",
            "lastName": "Behera",
            "email": "ashirbad.behera@em.com",
            "jobTitle": "Software Developer",
            "department": "Engineering"
}
```

DELETE  
http://localhost:8080/api/v1/employees/{id}  
  
To do, implement authentication using spring security  
  

