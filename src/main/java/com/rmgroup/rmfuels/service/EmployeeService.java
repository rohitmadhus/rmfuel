package com.rmgroup.rmfuels.service;

import com.rmgroup.rmfuels.model.Employee;
import com.rmgroup.rmfuels.model.EmployeeRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    
    public List<Employee> getEmployees(EmployeeRole employeeRole){
        Employee employee = new Employee(1);
        Employee employee2 = new Employee(2);

        return new ArrayList<>(){{add(employee);add(employee2);}};

    }
}
