package cc.jbdev.cruddemo.dao;

import cc.jbdev.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //no need to write any code lol



}
