import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: 'dashboard', loadComponent: () => import('./features/dashboard/dashboard.component').then(m => m.DashboardComponent) },
  { path: 'employees', loadComponent: () => import('./features/employee/employee-list.component').then(m => m.EmployeeListComponent) },
  { path: 'recruitment', loadComponent: () => import('./features/recruitment/recruitment.component').then(m => m.RecruitmentComponent) },
  { path: 'leave', loadComponent: () => import('./features/leave/leave.component').then(m => m.LeaveComponent) },
  { path: 'payroll', loadComponent: () => import('./features/payroll/payroll.component').then(m => m.PayrollComponent) },
  { path: 'performance', loadComponent: () => import('./features/performance/performance.component').then(m => m.PerformanceComponent) },
  { path: 'auth', loadChildren: () => import('./features/auth/auth.routes').then(m => m.AUTH_ROUTES) }
];
