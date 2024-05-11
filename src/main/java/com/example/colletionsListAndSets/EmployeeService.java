package com.example.colletionsListAndSets;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    String greet();

    Employee add(String firstName, String lastName, Integer salary, Integer department);

    Employee remove(String fistName, String lastName);

    Employee find(String firstName, String lastName);


    Collection<Employee> get();

    Collection<Employee> getAll();
}
