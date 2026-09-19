import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class RecruitmentService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getJobs() { return this.http.get<any[]>(`${this.apiUrl}/recruitment/jobs`); }
  addJob(data: any) { return this.http.post(`${this.apiUrl}/recruitment/jobs`, data); }
  deleteJob(id: number) { return this.http.delete(`${this.apiUrl}/recruitment/jobs/${id}`); }

  getApplicants(jobId?: number) {
    const url = jobId ? `${this.apiUrl}/recruitment/applicants?jobId=${jobId}` : `${this.apiUrl}/recruitment/applicants`;
    return this.http.get<any[]>(url);
  }
  addApplicant(data: any) { return this.http.post(`${this.apiUrl}/recruitment/applicants`, data); }
  updateStatus(id: number, status: string) { return this.http.put(`${this.apiUrl}/recruitment/applicants/${id}/status`, { status }); }
}
