package com.hrgenius.service;

import com.hrgenius.entity.Applicant;
import com.hrgenius.entity.JobPosting;
import com.hrgenius.repository.ApplicantRepository;
import com.hrgenius.repository.JobPostingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentService {

    private final JobPostingRepository jobRepo;
    private final ApplicantRepository applicantRepo;

    public RecruitmentService(JobPostingRepository jobRepo, ApplicantRepository applicantRepo) {
        this.jobRepo = jobRepo;
        this.applicantRepo = applicantRepo;
    }

    public List<JobPosting> getAllJobs() { return jobRepo.findAll(); }
    public JobPosting getJob(Long id) { return jobRepo.findById(id).orElseThrow(() -> new RuntimeException("Job not found")); }
    public JobPosting saveJob(JobPosting job) { return jobRepo.save(job); }
    public void deleteJob(Long id) { jobRepo.deleteById(id); }

    public List<Applicant> getApplicants(Long jobId) {
        if (jobId != null) return applicantRepo.findByJobId(jobId);
        return applicantRepo.findAll();
    }
    public Applicant saveApplicant(Applicant app) {
        if (app.getJob() != null && app.getJob().getId() != null) {
            JobPosting job = getJob(app.getJob().getId());
            app.setJob(job);
        }
        return applicantRepo.save(app);
    }
    public Applicant updateStatus(Long id, String status) {
        Applicant app = applicantRepo.findById(id).orElseThrow(() -> new RuntimeException("Applicant not found"));
        app.setStatus(status);
        return applicantRepo.save(app);
    }
}
