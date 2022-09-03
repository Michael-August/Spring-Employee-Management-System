package com.springboot_with_db.springboot_using_db.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot_with_db.springboot_using_db.exception.ResourceNotFoundException;
import com.springboot_with_db.springboot_using_db.model.Employee;
import com.springboot_with_db.springboot_using_db.repository.EmployeeRepository;
import com.springboot_with_db.springboot_using_db.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Dependency Injection
    private final EmployeeRepository employeeRepository;
    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        // check if employee exist
        if (employee.isEmpty()) {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
        return employee.get();
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        // check if employee with the given id exist in the database
        // Using .orElseThrow() here also works like if...else
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "id", id)
        );

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // Save to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "id", id)
        );
        employeeRepository.deleteById(id);
    }
    
}
