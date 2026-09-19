import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LeaveService } from './leave.service';
import { EmployeeService } from '../employee/employee.service';

@Component({
  selector: 'app-leave',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './leave.component.html'
})
export class LeaveComponent implements OnInit {
  leaves: any[] = [];
  employees: any[] = [];
  form: any = {};
  attendance: any[] = [];
  attForm: any = {};

  constructor(private leaveService: LeaveService, private empService: EmployeeService) {}

  ngOnInit() {
    this.loadLeaves(); this.loadAttendance();
    this.empService.getEmployees().subscribe(d => this.employees = d);
  }
  loadLeaves() { this.leaveService.getLeaves().subscribe(d => this.leaves = d); }
  loadAttendance() { this.leaveService.getAttendance().subscribe(d => this.attendance = d); }

  apply() {
    const data = { ...this.form, employee: { id: this.form.employeeId } };
    this.leaveService.applyLeave(data).subscribe(() => { this.loadLeaves(); this.form = {}; });
  }
  updateStatus(id: number, status: string) {
    this.leaveService.updateStatus(id, status).subscribe(() => this.loadLeaves());
  }
  mark() {
    const data = { ...this.attForm, employee: { id: this.attForm.employeeId } };
    this.leaveService.markAttendance(data).subscribe(() => { this.loadAttendance(); this.attForm = {}; });
  }
}
