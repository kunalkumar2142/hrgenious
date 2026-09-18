import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee-list.component.html'
})
export class EmployeeListComponent implements OnInit {
  employees: any[] = [];
  departments: any[] = [];
  showForm = false;
  formData: any = {};

  constructor(private empService: EmployeeService) {}

  ngOnInit() {
    this.loadEmployees();
    this.empService.getDepartments().subscribe(d => this.departments = d);
  }

  loadEmployees() {
    this.empService.getEmployees().subscribe(data => this.employees = data);
  }

  save() {
    if (this.formData.id) {
      this.empService.updateEmployee(this.formData.id, this.formData).subscribe(() => {
        this.loadEmployees(); this.showForm = false; this.formData = {};
      });
    } else {
      this.empService.addEmployee(this.formData).subscribe(() => {
        this.loadEmployees(); this.showForm = false; this.formData = {};
      });
    }
  }

  edit(emp: any) {
    this.formData = { ...emp, departmentId: emp.department?.id };
    this.showForm = true;
  }

  remove(id: number) {
    if (confirm('Delete this employee?')) {
      this.empService.deleteEmployee(id).subscribe(() => this.loadEmployees());
    }
  }
}
