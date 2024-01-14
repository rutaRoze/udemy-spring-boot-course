package com.springboot.learn.restapicruddemo.service;

import com.springboot.learn.restapicruddemo.dao.EmployeeRepository;
import com.springboot.learn.restapicruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
