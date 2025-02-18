package com.wipro.springboot.usecase1.service;

import com.wipro.springboot.usecase1.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    // Method to add or update employee
    public Employee addOrUpdateEmployee(Employee employee) {
        if(employee.getRole().equals("Developer") || employee.getRole().equals("Tester") || employee.getRole().equals("Architect")) {
            employeeMap.put(employee.getId(), employee);
            return employee;
        }
        return null; // Invalid role
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        return employeeMap.get(id);
    }

    // Method to update role of an employee based on their role
    public Employee updateRole(int id, String newRole) {
        Employee employee = employeeMap.get(id);
        if (employee != null && (newRole.equals("Developer") || newRole.equals("Tester") || newRole.equals("Architect"))) {
            employee.setRole(newRole);
            return employee;
        }
        return null;
    }
}
