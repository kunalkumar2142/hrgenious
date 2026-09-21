package com.hrgenius.controller;

import com.hrgenius.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository deptRepo;
    private final JobPostingRepository jobRepo;
    private final ApplicantRepository applicantRepo;
    private final LeaveRequestRepository leaveRepo;
    private final PayrollRepository payrollRepo;
    private final PerformanceReviewRepository perfRepo;

    public AnalyticsController(EmployeeRepository employeeRepo, DepartmentRepository deptRepo,
                               JobPostingRepository jobRepo, ApplicantRepository applicantRepo,
                               LeaveRequestRepository leaveRepo, PayrollRepository payrollRepo,
                               PerformanceReviewRepository perfRepo) {
        this.employeeRepo = employeeRepo;
        this.deptRepo = deptRepo;
        this.jobRepo = jobRepo;
        this.applicantRepo = applicantRepo;
        this.leaveRepo = leaveRepo;
        this.payrollRepo = payrollRepo;
        this.perfRepo = perfRepo;
    }

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalEmployees", employeeRepo.count());
        stats.put("totalDepartments", deptRepo.count());
        stats.put("totalJobs", jobRepo.count());
        stats.put("totalApplicants", applicantRepo.count());
        stats.put("totalLeaves", leaveRepo.count());
        stats.put("pendingLeaves", leaveRepo.findAll().stream().filter(l -> "PENDING".equals(l.getStatus())).count());
        stats.put("totalPayrolls", payrollRepo.count());
        stats.put("totalReviews", perfRepo.count());
        return stats;
    }
}
