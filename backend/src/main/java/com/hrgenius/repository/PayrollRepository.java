package com.hrgenius.repository;

import com.hrgenius.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    List<Payroll> findByEmployeeId(Long employeeId);
    List<Payroll> findByMonth(String month);
}
