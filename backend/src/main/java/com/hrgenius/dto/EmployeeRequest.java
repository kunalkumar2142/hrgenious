package com.hrgenius.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeRequest {
    private String empCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String designation;
    private LocalDate doj;
    private String status;
    private Long departmentId;
    private String address;
}
