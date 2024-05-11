package com.example.colletionsListAndSets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee findDepartmentSalaryMin(@RequestParam int department) {
        return departmentService.minSalary(department);
    }

    @GetMapping("/max-salary")
    public Employee findDepartmentSalaryMax(@RequestParam int department) {
        return departmentService.maxSalary(department);
    }

    @GetMapping(value = "/all", params = {"department"})
    public Collection<Employee> allEmployeeDepartment(@RequestParam Integer department) {
        return departmentService.employeeDepartment(department);
    }

    @GetMapping(value = "/all")
    public Map<Integer,List<Employee>> allEmployee() {
        return departmentService.allEmployee();
    }
}
