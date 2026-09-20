import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PayrollService } from './payroll.service';
import { EmployeeService } from '../employee/employee.service';

@Component({
  selector: 'app-payroll',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './payroll.component.html'
})
export class PayrollComponent implements OnInit {
  payrolls: any[] = [];
  employees: any[] = [];
  form: any = {};

  constructor(private payrollService: PayrollService, private empService: EmployeeService) {}

  ngOnInit() {
    this.load(); this.empService.getEmployees().subscribe(d => this.employees = d);
  }
  load() { this.payrollService.getPayrolls().subscribe(d => this.payrolls = d); }
  run() {
    const data = { ...this.form, employee: { id: this.form.employeeId } };
    this.payrollService.runPayroll(data).subscribe(() => { this.load(); this.form = {}; });
  }
}
