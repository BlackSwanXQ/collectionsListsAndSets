package com.example.colletionsListAndSets.Services;

import com.example.colletionsListAndSets.Employee.Employee;

import java.util.Collection;

public interface EmployeeService {
    String greet();

    Employee add(String firstName, String lastName, Integer salary, Integer department);

    Employee remove(String fistName, String lastName);

    Employee find(String firstName, String lastName);


    Collection<Employee> get();

    Collection<Employee> getAll();
}
