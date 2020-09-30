# spring-boot-rest-demo
  
This is a Spring Boot - Hibernate REST API demo (using mysql). Once running you can access:  
  
  GET - /api/employees to get a list of all employees.   
  GET - /api/employees/your_int to get an employee by Id number.   
  POST - /api/employees/, passing a new Employee in JSON format to add a new employee.   
  PUT - /api/employees/, passing an updated Employee in JSON format to update an employee.    
  DELETE - /api/employees/, passing an employee in JSON format to delete an employee. 
      
     
# Spring Data JPA
  
There's a branch that replaces Hibernate with Spring Data JPA   
   
# Spring Data Rest  
   
The Spring Data Rest dependency provides a REST implementation without the need to use the previous Service and Rest classes. Only needs the base Entity Employee and the EmployeeRepository class. See branch called: spring-data-JPA-rest-demo.  

