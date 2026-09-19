import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RecruitmentService } from './recruitment.service';

@Component({
  selector: 'app-recruitment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './recruitment.component.html'
})
export class RecruitmentComponent implements OnInit {
  jobs: any[] = [];
  applicants: any[] = [];
  jobForm: any = {};
  appForm: any = {};

  constructor(private service: RecruitmentService) {}

  ngOnInit() { this.loadJobs(); this.loadApplicants(); }

  loadJobs() { this.service.getJobs().subscribe(d => this.jobs = d); }
  loadApplicants() { this.service.getApplicants().subscribe(d => this.applicants = d); }

  addJob() {
    this.service.addJob(this.jobForm).subscribe(() => { this.loadJobs(); this.jobForm = {}; });
  }

  addApplicant() {
    const data = { ...this.appForm, job: { id: this.appForm.jobId } };
    this.service.addApplicant(data).subscribe(() => { this.loadApplicants(); this.appForm = {}; });
  }

  changeStatus(id: number, status: string) {
    this.service.updateStatus(id, status).subscribe(() => this.loadApplicants());
  }
}
