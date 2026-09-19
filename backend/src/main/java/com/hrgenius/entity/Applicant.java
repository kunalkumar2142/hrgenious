package com.hrgenius.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "applicants")
@Getter
@Setter
public class Applicant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_seq")
    @SequenceGenerator(name = "app_seq", sequenceName = "app_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String phone;
    private String resumeLink;
    private String status = "APPLIED"; // APPLIED, SCREENING, INTERVIEW, OFFERED, HIRED, REJECTED

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPosting job;

    private LocalDate appliedDate = LocalDate.now();
}
