package com.springboot.learn.restapicruddemo.service;

import com.springboot.learn.restapicruddemo.entity.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> findAll();

    Employee findEmployeeById(int id);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
