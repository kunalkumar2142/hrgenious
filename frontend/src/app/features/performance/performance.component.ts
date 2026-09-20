import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PerformanceService } from './performance.service';
import { EmployeeService } from '../employee/employee.service';

@Component({
  selector: 'app-performance',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './performance.component.html'
})
export class PerformanceComponent implements OnInit {
  reviews: any[] = [];
  employees: any[] = [];
  form: any = {};

  constructor(private perfService: PerformanceService, private empService: EmployeeService) {}

  ngOnInit() {
    this.load(); this.empService.getEmployees().subscribe(d => this.employees = d);
  }
  load() { this.perfService.getReviews().subscribe(d => this.reviews = d); }
  add() {
    const data = { ...this.form, employee: { id: this.form.employeeId } };
    this.perfService.addReview(data).subscribe(() => { this.load(); this.form = {}; });
  }
  update(id: number, status: string) {
    this.perfService.updateStatus(id, status).subscribe(() => this.load());
  }
}
