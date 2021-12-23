package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
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
    public void createEmployee(Employee newEmployee) {
        employeeRepository.save(newEmployee);
    }

    @Override
    public boolean updateEmployee(Employee updatedEmployee) {
        Optional<Employee> employeeFound = employeeRepository.findById(updatedEmployee.getEmployeeId());
        if (employeeFound.isPresent()) {
            updatedEmployee = employeeFound.get();
            employeeRepository.save(updatedEmployee);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> listOfEmployee = employeeRepository.findAll();
        return listOfEmployee;
    }
}
