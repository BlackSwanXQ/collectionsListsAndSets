package com.example.colletionsListAndSets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String greet() {
        return employeeService.greet();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastname) {
        Employee employee = new Employee(firstName, lastname);
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastname) {
        Employee employee = new Employee(firstName, lastname);
        return employeeService.removeEmployee(employee);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastname) {
        Employee employee = new Employee(firstName, lastname);
        return employeeService.findEmployee(employee);

    }

    @GetMapping("/get")
    public List<Employee> get() {
        return employeeService.getEmployees();
    }


}
