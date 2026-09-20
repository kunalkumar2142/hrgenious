package com.hrgenius.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payrolls")
@Getter
@Setter
public class Payroll extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_seq")
    @SequenceGenerator(name = "pay_seq", sequenceName = "pay_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String month; // e.g. 2026-04
    private Double basic;
    private Double hra;
    private Double allowance;
    private Double deductions;
    private Double netSalary;
    private String status = "PENDING"; // PENDING, PAID
}
