package com.hrgenius.service;

import com.hrgenius.entity.Employee;
import com.hrgenius.entity.PerformanceReview;
import com.hrgenius.repository.EmployeeRepository;
import com.hrgenius.repository.PerformanceReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {

    private final PerformanceReviewRepository reviewRepo;
    private final EmployeeRepository employeeRepo;

    public PerformanceService(PerformanceReviewRepository reviewRepo, EmployeeRepository employeeRepo) {
        this.reviewRepo = reviewRepo;
        this.employeeRepo = employeeRepo;
    }

    public List<PerformanceReview> getAll() { return reviewRepo.findAll(); }

    public PerformanceReview addReview(PerformanceReview review) {
        if (review.getEmployee() != null && review.getEmployee().getId() != null) {
            Employee emp = employeeRepo.findById(review.getEmployee().getId()).orElseThrow(() -> new RuntimeException("Employee not found"));
            review.setEmployee(emp);
        }
        return reviewRepo.save(review);
    }

    public PerformanceReview updateStatus(Long id, String status) {
        PerformanceReview r = reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        r.setStatus(status);
        return reviewRepo.save(r);
    }
}
