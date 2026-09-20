import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class PayrollService {
  private apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}
  getPayrolls() { return this.http.get<any[]>(`${this.apiUrl}/payrolls`); }
  runPayroll(data: any) { return this.http.post(`${this.apiUrl}/payrolls/run`, data); }
}
