package com.demo.employeemanager.service;

import com.demo.employeemanager.exception.UserNotFoundException;
import com.demo.employeemanager.model.Employee;
import com.demo.employeemanager.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        System.out.println("SERVICE");
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteEmployeeById(id);
    }

    public Employee findEmployee(long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }
}
