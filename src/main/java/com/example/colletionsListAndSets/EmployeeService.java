package com.example.colletionsListAndSets;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private final int maxEmployees = 100;


    @Override
    public String greet() {
        return "<h1> Hello worker! </h1>";
    }


    @Override
    public Employee addEmployee(Employee employee) {

        if (maxEmployees <= employees.size()) {
            throw new EmployeeStoragelsFullException("Collection is overflowing");
        }

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee already exist");
        }
        employees.add(employee);

        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFountException("Employee not found");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFountException("Employee not found");
        }
        employees.contains(employee);
        return employee;
    }

    public List<Employee> getEmployees() {

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
        return employees.stream().toList();
    }
}
