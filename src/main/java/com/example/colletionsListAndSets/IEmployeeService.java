package com.example.colletionsListAndSets;

import java.util.List;

public interface IEmployeeService {
    String greet();

    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    List<Employee> getEmployees();
}
