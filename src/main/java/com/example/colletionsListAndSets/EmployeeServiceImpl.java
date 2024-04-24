package com.example.colletionsListAndSets;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;
    private final int employeesMax;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
        this.employeesMax = 5;
    }

    @Override
    public String greet() {
        return "<h1> Hello worker! </h1>";
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee alrady exist");
        }
        if (employees.size() >= employeesMax) {
            throw new EmployeeStoragelsFullException("List is overflowing");
        }
        employees.add(employee);
        return employee;

    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFountException("Employee not found");

    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFountException("Employee not found");
    }

    @Override
    public Collection<Employee> get() {
        return Collections.unmodifiableList(employees);
    }
}
