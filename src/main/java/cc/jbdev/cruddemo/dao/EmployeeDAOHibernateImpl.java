package cc.jbdev.cruddemo.dao;

import cc.jbdev.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    //THIS CLASS USES THE NATIVE HIBERNATE API


    // define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection -- can use field injection also
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // get the current hibernate session
        Session theSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery = theSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get the current hibernate session
        Session theSession = entityManager.unwrap(Session.class);

        //get the employee
        Employee theEmployee = theSession.get(Employee.class, theId);

        // return the employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        // get the current hibernate session
        Session theSession = entityManager.unwrap(Session.class);

        //save employee
        // (if the id passed is 0 it will do a save, else will update)
        theSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {

        //get the current hibernate session
        Session theSession = entityManager.unwrap(Session.class);

        //delete employee with primary key
        Query theQuery = theSession.createQuery("delete from Employee where id=:employeeId");

        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();

    }
}
