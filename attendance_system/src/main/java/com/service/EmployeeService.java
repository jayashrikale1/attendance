package com.service;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Existing methods
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void saveEmployee(Employee employee) {
        // Check if employee doesn't have empId, then generate it
        if (employee.getEmpId() == null || employee.getEmpId().isEmpty()) {
            employee.setEmpId(generateEmployeeId());
        }
        
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // New method to get the total employee count
    public long getEmployeeCount() {
        return employeeRepository.count();  // This will return the total number of employees
    }

    // New method to generate employee ID in the format "EMP" + random number
    public String generateEmployeeId() {
        String prefix = "EMP";
        Random random = new Random();
        int number = random.nextInt(100000, 999999); // Generates a random 6-digit number
        return prefix + number;
    }
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

}
