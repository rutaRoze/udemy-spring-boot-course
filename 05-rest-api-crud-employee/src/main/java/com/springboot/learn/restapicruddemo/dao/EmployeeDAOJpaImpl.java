package com.springboot.learn.restapicruddemo.dao;

import com.springboot.learn.restapicruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        //execute query and get result
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findEmployeeById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        //if id is 0 then it inserts new employee, otherwise updates
        Employee employeeDB = entityManager.merge(employee);

        return employeeDB;
    }

    @Override
    public void deleteEmployeeById(int id) {

        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);

    }
}
