package com.demo.employeemanager.controller;

import com.demo.employeemanager.model.Employee;
import com.demo.employeemanager.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Data
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity <>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
        return new ResponseEntity <>(employeeService.findEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> updaseEmployee(@RequestBody Employee employee){
        Employee newEmplyee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmplyee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
