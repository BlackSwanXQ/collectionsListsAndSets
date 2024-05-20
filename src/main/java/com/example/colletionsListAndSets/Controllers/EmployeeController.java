package com.example.colletionsListAndSets.Controllers;

import com.example.colletionsListAndSets.Employee.Employee;
import com.example.colletionsListAndSets.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String greet() {
        return employeeService.greet();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam Integer salary,
                                @RequestParam Integer department) {

        return employeeService.add(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName) {
//        Employee employee = new Employee(firstName, lastName);
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/get")
    public Collection<Employee> getEmployees() {
        return employeeService.get();
    }


}
