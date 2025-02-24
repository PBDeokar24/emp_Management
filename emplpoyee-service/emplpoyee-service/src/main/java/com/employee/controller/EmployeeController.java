package com.employee.controller;

import com.employee.entitiy.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3360)
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{emp_id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable("emp_id") Long emp_id) {
        return ResponseEntity.ok(employeeService.getEmployeeByID(emp_id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @PatchMapping("/employees/{emp_id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("emp_id") Long empID) {

        Employee empobj=employeeService.getEmployeeByID(empID);
        if(empobj!=null){
            empobj.setManager(employee.getManager());
            empobj.setEmp_name(employee.getEmp_name());
            empobj.setSalary(employee.getSalary());

    }
        return ResponseEntity.ok(employeeService.updateEmployee(empobj));

    }

    @DeleteMapping("/employees/{emp_id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("emp_id") Long emp_id) {

        Employee employee=employeeService.getEmployeeByID(emp_id);
        String deleteMsg=null;
        if(employee!=null){
            deleteMsg=employeeService.deleteEmployee(employee);
        }
        return ResponseEntity.ok(deleteMsg);
    }

}
