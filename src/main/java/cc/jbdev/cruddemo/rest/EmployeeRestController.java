package cc.jbdev.cruddemo.rest;

import cc.jbdev.cruddemo.dao.EmployeeDAO;
import cc.jbdev.cruddemo.entity.Employee;
import cc.jbdev.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // get a specific employee
    @GetMapping("/employees/{theId}")
    public Employee getEmployee(@PathVariable int theId){

        Employee tempEmployee = employeeService.findById(theId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - " + theId);
        }

        return tempEmployee;

    }

    //Adding a new employee
    //@RequestBody is the same as pathVariable, only that it works for data received in JSON format.
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //just in case they apss an id in JSON, set it to 0.
        //This is to force a save of a new item, instead of an update
        theEmployee.setId(0);

        employeeService.save(theEmployee);
        return theEmployee;
    }


    //Update an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        if (theEmployee == null){
            throw new RuntimeException("Employee not found, employee id passed: " + theEmployee.getId());
        }

        employeeService.save(theEmployee);
        return theEmployee;
    }

    //delete an employee
    @DeleteMapping("/employees")
    public Employee deleteEmployee(@RequestBody Employee theEmployee){

        employeeService.delete(theEmployee.getId());

        return theEmployee;

    }
}
