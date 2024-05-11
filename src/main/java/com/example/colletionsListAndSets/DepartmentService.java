package com.example.colletionsListAndSets;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee minSalary(int department);

    Employee maxSalary(int department);

    Collection<Employee> employeeDepartment(int department);

    Map<Integer, List<Employee>> allEmployee();
}
