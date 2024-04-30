package com.example.colletionsListAndSets;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface EmployeeService {
    String greet();

    Employee add(String firstName, String lastName);

    Employee remove(String fistName, String lastName);

    Employee find(String firstName, String lastName);

    List<Employee> get();
}
