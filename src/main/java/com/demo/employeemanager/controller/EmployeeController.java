package com.demo.employeemanager.controller;

import com.demo.employeemanager.model.Employee;
import com.demo.employeemanager.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.List;

@RestController
@RequestMapping("/empoyee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity <>(employeeService.findAllEmployees(), HttpStatus.OK);
    }

}
