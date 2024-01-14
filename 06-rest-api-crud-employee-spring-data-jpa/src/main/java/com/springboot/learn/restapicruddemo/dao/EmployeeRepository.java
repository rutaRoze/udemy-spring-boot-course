package com.springboot.learn.restapicruddemo.dao;

import com.springboot.learn.restapicruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
