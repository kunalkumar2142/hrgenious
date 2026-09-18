package com.hrgenius.repository;

import com.hrgenius.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    boolean existsByEmpCode(String empCode);
    boolean existsByEmail(String email);
}
