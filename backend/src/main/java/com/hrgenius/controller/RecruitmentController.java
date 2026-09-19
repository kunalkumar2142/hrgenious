package com.hrgenius.controller;

import com.hrgenius.entity.Applicant;
import com.hrgenius.entity.JobPosting;
import com.hrgenius.service.RecruitmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/recruitment")
public class RecruitmentController {

    private final RecruitmentService service;

    public RecruitmentController(RecruitmentService service) {
        this.service = service;
    }

    @GetMapping("/jobs")
    public List<JobPosting> getJobs() { return service.getAllJobs(); }

    @PostMapping("/jobs")
    public JobPosting createJob(@RequestBody JobPosting job) { return service.saveJob(job); }

    @DeleteMapping("/jobs/{id}")
    public String deleteJob(@PathVariable Long id) { service.deleteJob(id); return "deleted"; }

    @GetMapping("/applicants")
    public List<Applicant> getApplicants(@RequestParam(required = false) Long jobId) { return service.getApplicants(jobId); }

    @PostMapping("/applicants")
    public Applicant addApplicant(@RequestBody Applicant app) { return service.saveApplicant(app); }

    @PutMapping("/applicants/{id}/status")
    public Applicant updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return service.updateStatus(id, body.get("status"));
    }
}
