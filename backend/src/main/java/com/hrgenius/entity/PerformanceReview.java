package com.hrgenius.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "performance_reviews")
@Getter
@Setter
public class PerformanceReview extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perf_seq")
    @SequenceGenerator(name = "perf_seq", sequenceName = "perf_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String reviewerName;
    private String period; // e.g. 2026-Q1
    private Integer rating; // 1-5
    private String goals;
    private String feedback;
    private String status = "PENDING"; // PENDING, COMPLETED
}
