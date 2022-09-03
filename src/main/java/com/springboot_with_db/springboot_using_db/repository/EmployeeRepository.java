package com.springboot_with_db.springboot_using_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot_with_db.springboot_using_db.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
