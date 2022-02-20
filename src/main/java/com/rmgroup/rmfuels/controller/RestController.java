package com.rmgroup.rmfuels.controller;

import com.rmgroup.rmfuels.model.Employee;
import com.rmgroup.rmfuels.model.EmployeeRole;
import com.rmgroup.rmfuels.service.EmployeeService;
import com.rmgroup.rmfuels.util.SalaryExelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RestController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/export/salary/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=salary_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Employee> employeeList = employeeService.getEmployees(EmployeeRole.STAFF);

        SalaryExelExporter excelExporter = new SalaryExelExporter(employeeList);

        excelExporter.export(response);
    }
}
