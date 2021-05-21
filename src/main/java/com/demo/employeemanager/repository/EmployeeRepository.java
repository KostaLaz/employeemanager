package com.demo.employeemanager.repository;

import com.demo.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Transactional
    void deleteEmployeeById(long id);

    Optional<Employee> findEmployeeById(long id);

}
