package com.hrgenius.controller;

import com.hrgenius.entity.Attendance;
import com.hrgenius.entity.LeaveRequest;
import com.hrgenius.service.LeaveAttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LeaveAttendanceController {

    private final LeaveAttendanceService service;

    public LeaveAttendanceController(LeaveAttendanceService service) {
        this.service = service;
    }

    @GetMapping("/leaves")
    public List<LeaveRequest> getLeaves() { return service.getLeaves(); }

    @PostMapping("/leaves")
    public LeaveRequest apply(@RequestBody LeaveRequest req) { return service.applyLeave(req); }

    @PutMapping("/leaves/{id}/status")
    public LeaveRequest updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return service.updateLeaveStatus(id, body.get("status"));
    }

    @GetMapping("/attendance")
    public List<Attendance> getAttendance() { return service.getAttendance(); }

    @PostMapping("/attendance")
    public Attendance mark(@RequestBody Attendance att) { return service.markAttendance(att); }
}
