package com.hrgenius.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq", sequenceName = "emp_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String empCode;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;
    private String designation;
    private LocalDate doj;
    private String status = "ACTIVE";

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private String address;
}
