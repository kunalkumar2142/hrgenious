package com.hrgenius.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
@Getter
@Setter
public class Attendance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "att_seq")
    @SequenceGenerator(name = "att_seq", sequenceName = "att_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate date = LocalDate.now();
    private String status = "PRESENT"; // PRESENT, ABSENT, WFH, LEAVE
    private LocalTime checkIn;
    private LocalTime checkOut;
}
