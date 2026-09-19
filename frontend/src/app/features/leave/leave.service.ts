import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class LeaveService {
  private apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}
  getLeaves() { return this.http.get<any[]>(`${this.apiUrl}/leaves`); }
  applyLeave(data: any) { return this.http.post(`${this.apiUrl}/leaves`, data); }
  updateStatus(id: number, status: string) { return this.http.put(`${this.apiUrl}/leaves/${id}/status`, { status }); }
  getAttendance() { return this.http.get<any[]>(`${this.apiUrl}/attendance`); }
  markAttendance(data: any) { return this.http.post(`${this.apiUrl}/attendance`, data); }
}
