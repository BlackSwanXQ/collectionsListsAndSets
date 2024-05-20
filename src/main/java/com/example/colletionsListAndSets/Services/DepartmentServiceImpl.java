package com.example.colletionsListAndSets.Services;

import com.example.colletionsListAndSets.Employee.Employee;
import com.example.colletionsListAndSets.Exceptions.EmployeeNotFountException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee minSalary(int department) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(EmployeeNotFountException::new);
    }

    @Override
    public Employee maxSalary(int department) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFountException::new);
    }

    @Override
    public Collection<Employee> employeeDepartment(int department) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

    }

    @Override
    public Map<Integer, List<Employee>> allEmployee() {
        return employeeService.getAll()
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }

}
