package com.controller;

import com.entity.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/list";
    }

    
    @GetMapping("/view_emp/{id}")
    public String viewEmp(@PathVariable Long id, Model model) {
        // Fetch the employee by ID
        Employee employee = employeeService.getEmployeeById(id);

        // Add the employee object to the model
        model.addAttribute("employee", employee);

        // Return the view name for displaying the employee's details
        return "employee/viewemp";
    }

    
    
    @GetMapping("/test")
    public String test() {
        return "test";  // Return the test view
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/add";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        long employeeCount = employeeService.getEmployeeCount();  // Get total employees from service
        model.addAttribute("employeeCount", employeeCount);
        return "index";  // This should return the index.html view
    }

    // This method now generates empId before saving the employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // Call the service to save the employee, which includes generating the empId
        employeeService.saveEmployee(employee);
        return "redirect:/employees";  // Redirect to employee list or dashboard
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";  // Redirect back to employee list
    }
}
