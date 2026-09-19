package com.hrgenius.service;

import com.hrgenius.entity.Attendance;
import com.hrgenius.entity.Employee;
import com.hrgenius.entity.LeaveRequest;
import com.hrgenius.repository.AttendanceRepository;
import com.hrgenius.repository.EmployeeRepository;
import com.hrgenius.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveAttendanceService {

    private final LeaveRequestRepository leaveRepo;
    private final AttendanceRepository attendanceRepo;
    private final EmployeeRepository employeeRepo;

    public LeaveAttendanceService(LeaveRequestRepository leaveRepo, AttendanceRepository attendanceRepo, EmployeeRepository employeeRepo) {
        this.leaveRepo = leaveRepo;
        this.attendanceRepo = attendanceRepo;
        this.employeeRepo = employeeRepo;
    }

    public List<LeaveRequest> getLeaves() { return leaveRepo.findAll(); }
    public LeaveRequest applyLeave(LeaveRequest req) {
        if (req.getEmployee() != null && req.getEmployee().getId() != null) {
            Employee emp = employeeRepo.findById(req.getEmployee().getId()).orElseThrow(() -> new RuntimeException("Employee not found"));
            req.setEmployee(emp);
        }
        return leaveRepo.save(req);
    }
    public LeaveRequest updateLeaveStatus(Long id, String status) {
        LeaveRequest lr = leaveRepo.findById(id).orElseThrow(() -> new RuntimeException("Leave not found"));
        lr.setStatus(status);
        return leaveRepo.save(lr);
    }

    public List<Attendance> getAttendance() { return attendanceRepo.findAll(); }
    public Attendance markAttendance(Attendance att) {
        if (att.getEmployee() != null && att.getEmployee().getId() != null) {
            Employee emp = employeeRepo.findById(att.getEmployee().getId()).orElseThrow(() -> new RuntimeException("Employee not found"));
            att.setEmployee(emp);
        }
        return attendanceRepo.save(att);
    }
}
