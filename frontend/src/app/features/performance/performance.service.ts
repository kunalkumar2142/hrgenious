import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class PerformanceService {
  private apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}
  getReviews() { return this.http.get<any[]>(`${this.apiUrl}/performance`); }
  addReview(data: any) { return this.http.post(`${this.apiUrl}/performance`, data); }
  updateStatus(id: number, status: string) { return this.http.put(`${this.apiUrl}/performance/${id}/status`, { status }); }
}
