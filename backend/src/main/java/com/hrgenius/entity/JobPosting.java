package com.hrgenius.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "job_postings")
@Getter
@Setter
public class JobPosting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_seq")
    @SequenceGenerator(name = "job_seq", sequenceName = "job_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String department;
    private String location;
    private String description;
    private String status = "OPEN"; // OPEN, CLOSED
    private LocalDate postedDate = LocalDate.now();
}
