package com.springRestAPI.springRest.Service;

import com.springRestAPI.springRest.Entities.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
   List<Employee> list;
    public EmployeeServiceImpl()
    {
        list = new ArrayList<>();
        list.add(new Employee("Hrishi",208,23));
        list.add(new Employee("Labham",280,25));
        list.add(new Employee("Shantanu",215,32));
    }

    @Override
    public List<Employee> getEmployees()
    {
        return list;
    }

    @Override
    public Employee getEmployee(int id)
    {
        Employee emp = null;
        for (Employee e : list)
        {
            if(e.getId()==id) {
                emp = e;
                break;
            }
        }
        return emp;
    }

    @Override
    public Employee addEmployee(Employee employee)
    {
        list.add(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(int id)
    {


        List<Employee> rmvList = new ArrayList<>();
        Employee emp = null;
        Iterator<Employee> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next().getId() == id)
            {
                rmvList.add(itr.next());
                emp = itr.next();
                list.removeAll(rmvList);
            }
        }
        return emp;
    }
}
