import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  template: `
    <nav style="padding:10px; background:#f0f0f0;">
      <a routerLink="/dashboard">Dashboard</a> |
      <a routerLink="/employees">Employees</a> |
      <a routerLink="/recruitment">Recruitment</a> |
      <a routerLink="/leave">Leave</a> |
      <a routerLink="/payroll">Payroll</a> |
      <a routerLink="/performance">Performance</a> |
      <a routerLink="/auth/login">Login</a>
    </nav>
    <div style="padding:15px;">
      <router-outlet></router-outlet>
    </div>
  `
})
export class AppComponent {
  title = 'HRGenius';
}
