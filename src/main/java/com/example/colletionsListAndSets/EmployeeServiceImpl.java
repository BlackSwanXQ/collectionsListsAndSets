package com.example.colletionsListAndSets;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private final int employeesMax;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        this.employeesMax = 5;
    }

    @Override
    public String greet() {
        return "<h1> Hello worker! </h1>";
    }

    @Override
    public Employee add(String firstName, String lastName, Integer salary, Integer department) {
        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Employee already exist");
        }
        if (employees.size() >= employeesMax) {
            throw new EmployeeStoragelsFullException("List is overflowing");
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.remove(key);
        }
        throw new EmployeeNotFountException("Employee not found");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFountException("Employee not found");
    }

    @Override
    public Collection<Employee> get() {
        return Collections.unmodifiableCollection(employees.values());
    }


    private String buildKey(String firstname, String lastname) {
        return firstname + lastname;
    }

    @Override
    public Collection<Employee> getAll() {
        return employees.values();
    }
}

