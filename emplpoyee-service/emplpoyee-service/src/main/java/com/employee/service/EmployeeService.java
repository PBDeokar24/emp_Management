package com.employee.service;

import com.employee.entitiy.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeByID(Long emp_id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    String  deleteEmployee(Employee employee);

}
