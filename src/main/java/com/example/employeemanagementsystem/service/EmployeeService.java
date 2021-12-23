package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    void createEmployee(Employee newEmployee);
    boolean updateEmployee(Employee updatedEmployee);
    boolean deleteEmployee(Long employeeId);
    List<Employee> getAllEmployee();
}
