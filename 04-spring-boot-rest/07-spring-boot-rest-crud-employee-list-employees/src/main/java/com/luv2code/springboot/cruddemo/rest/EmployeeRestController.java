package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public  EmployeeRestController(EmployeeService service) {
        employeeService = service;
    }

    @GetMapping("/employees")
    public  List<Employee> findAll() {
        return employeeService.findAllService();
    }

    @GetMapping("/employees/{id}")
    public  Employee findById(@PathVariable int id) {
        Employee theEmployee =  employeeService.findById(id);
        if(theEmployee == null)
            throw  new RuntimeException("Employee id not found: " + id);

        return  theEmployee;
    }

    @PostMapping("/employees")
    public  Employee saveEmpyoee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee newEmp = employeeService.save(theEmployee);
        return newEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee theEmp = employeeService.save(theEmployee);
        return theEmp;
    }

    @DeleteMapping("/employees/{id}")
    public  boolean deleteEmployee(@PathVariable int id) {
        Employee theEmployee =  employeeService.findById(id);
        if(theEmployee == null)
            throw  new RuntimeException("Employee id not found: " + id);

        employeeService.deleteById(id);
        return true;
    }
}








