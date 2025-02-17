package com.wipro.springboot.usecase1.controller;

import com.wipro.springboot.usecase1.entity.Employee;
import com.wipro.springboot.usecase1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Endpoint to add or update an employee
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addOrUpdateEmployee(employee);
    }

    // Endpoint to get an employee by ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    // Endpoint to update employee's role
    @PutMapping("/update-role/{id}")
    public Employee updateRole(@PathVariable int id, @RequestParam String role) {
        return employeeService.updateRole(id, role);
    }
}
