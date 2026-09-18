import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class EmployeeService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getEmployees() {
    return this.http.get<any[]>(`${this.apiUrl}/employees`);
  }

  getEmployee(id: number) {
    return this.http.get<any>(`${this.apiUrl}/employees/${id}`);
  }

  addEmployee(data: any) {
    return this.http.post(`${this.apiUrl}/employees`, data);
  }

  updateEmployee(id: number, data: any) {
    return this.http.put(`${this.apiUrl}/employees/${id}`, data);
  }

  deleteEmployee(id: number) {
    return this.http.delete(`${this.apiUrl}/employees/${id}`);
  }

  getDepartments() {
    return this.http.get<any[]>(`${this.apiUrl}/departments`);
  }
}
