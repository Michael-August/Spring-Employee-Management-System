package com.springboot_with_db.springboot_using_db.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_with_db.springboot_using_db.model.Employee;
import com.springboot_with_db.springboot_using_db.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    // Dependency Injection
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // Build CREATE Employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // Build GET ALL EMPLOYEES REST API
    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployee();
    }

    // Build GET employee by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    // Build UPDATE employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
    }

    // Build DELETE employee REST API
    @DeleteMapping({"id"})
    public ResponseEntity<String> deleteEployee(@PathVariable("id") long employeeId) {
        employeeService.deleteEmployee(employeeId);

        return new ResponseEntity<String>("Employee Deleted successfully!", HttpStatus.OK);
    }


}
