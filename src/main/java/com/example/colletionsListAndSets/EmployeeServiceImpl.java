package com.example.colletionsListAndSets;

import org.springframework.stereotype.Service;

import java.util.*;

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
    public Employee add(String firstName, String lastName) {
        String key = firstName + lastName;
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Employee alrady exist");
        }
        if (employees.size() >= employeesMax) {
            throw new EmployeeStoragelsFullException("List is overflowing");
        }
        employees.put(key, employee);
        System.out.println(employees);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String key = firstName + lastName;
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(key)) {
            employees.remove(key);
            return employee;
        }
        throw new EmployeeNotFountException("Employee not found");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = firstName + lastName;
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(key)) {
            return employee;
        }
        throw new EmployeeNotFountException("Employee not found");
    }

    @Override
    public List<Employee> get() {
//        return Collections.unmodifiableList(employees);
        List<Employee> lst = new ArrayList<>(employees.values());
        return Collections.unmodifiableList(lst);
    }
}

