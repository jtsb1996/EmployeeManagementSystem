package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value="/addemployee")
    public String addEmployeePage(Model model) {
        model.addAttribute("newemployee", new Employee());
        return "addemployeepage";
    }

    @PostMapping(value="/addemployee")
    public String addEmployee(@ModelAttribute("newemployee")Employee newEmployee) {
        employeeService.createEmployee(newEmployee);
        return "successful";
    }
}
