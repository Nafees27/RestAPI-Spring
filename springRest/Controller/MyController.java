package com.springRestAPI.springRest.Controller;

import com.springRestAPI.springRest.Entities.Employee;
import com.springRestAPI.springRest.Exception.EmployeeNotFound;
import com.springRestAPI.springRest.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController
{
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/home")
    public String home()
    {
        return "Welcome to Spring Boot";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
     }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) throws EmployeeNotFound
    {
        if(this.employeeService.getEmployee(id) == null)
        {
            throw new EmployeeNotFound("Id Not Found");
        }
        return this.employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return this.employeeService.addEmployee(employee);
    }

    @DeleteMapping("/deleteEmp/{id}")
    public Employee deleteEmployee(@PathVariable int id)
    {
        return employeeService.deleteEmployee(id);
    }
}
