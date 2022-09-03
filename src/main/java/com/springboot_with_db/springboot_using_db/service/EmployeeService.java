package com.springboot_with_db.springboot_using_db.service;

import java.util.List;

import com.springboot_with_db.springboot_using_db.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
