package com.hrgenius.service;

import com.hrgenius.entity.Employee;
import com.hrgenius.entity.Payroll;
import com.hrgenius.repository.EmployeeRepository;
import com.hrgenius.repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {

    private final PayrollRepository payrollRepo;
    private final EmployeeRepository employeeRepo;

    public PayrollService(PayrollRepository payrollRepo, EmployeeRepository employeeRepo) {
        this.payrollRepo = payrollRepo;
        this.employeeRepo = employeeRepo;
    }

    public List<Payroll> getAll() { return payrollRepo.findAll(); }

    public Payroll runPayroll(Payroll payroll) {
        if (payroll.getEmployee() != null && payroll.getEmployee().getId() != null) {
            Employee emp = employeeRepo.findById(payroll.getEmployee().getId()).orElseThrow(() -> new RuntimeException("Employee not found"));
            payroll.setEmployee(emp);
        }
        double gross = (payroll.getBasic() != null ? payroll.getBasic() : 0)
                + (payroll.getHra() != null ? payroll.getHra() : 0)
                + (payroll.getAllowance() != null ? payroll.getAllowance() : 0);
        double ded = payroll.getDeductions() != null ? payroll.getDeductions() : 0;
        payroll.setNetSalary(gross - ded);
        payroll.setStatus("PAID");
        return payrollRepo.save(payroll);
    }

    public Payroll getById(Long id) { return payrollRepo.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found")); }
}
