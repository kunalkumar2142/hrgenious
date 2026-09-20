package com.hrgenius.controller;

import com.hrgenius.entity.PerformanceReview;
import com.hrgenius.service.PerformanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/performance")
public class PerformanceController {

    private final PerformanceService service;

    public PerformanceController(PerformanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<PerformanceReview> getAll() { return service.getAll(); }

    @PostMapping
    public PerformanceReview add(@RequestBody PerformanceReview review) { return service.addReview(review); }

    @PutMapping("/{id}/status")
    public PerformanceReview updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return service.updateStatus(id, body.get("status"));
    }
}
