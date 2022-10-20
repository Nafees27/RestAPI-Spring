package com.springRestAPI.springRest.Service;

import com.springRestAPI.springRest.Entities.Employee;

import java.util.List;

public interface EmployeeService
{
    List<Employee> getEmployees();

    Employee getEmployee(int id);

    Employee addEmployee(Employee employee);

    Employee deleteEmployee(int id);
}
