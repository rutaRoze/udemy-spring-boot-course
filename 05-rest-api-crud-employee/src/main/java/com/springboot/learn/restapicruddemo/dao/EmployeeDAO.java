package com.springboot.learn.restapicruddemo.dao;

import com.springboot.learn.restapicruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findEmployeeById(int id);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
