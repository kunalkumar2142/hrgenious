# HRGenius - HR Management System (HRMS) - P_016

Full Stack HRMS for Employee data, Recruitment, Payroll, Performance and HR Analytics.

**Stack:** Java 21, Spring Boot 3.2.5, Spring Security JWT, Hibernate JPA, Oracle DB 21c XE, Angular 17, Angular Material

## Features
- Login with JWT and role based access (ADMIN, HR_MANAGER, MANAGER, EMPLOYEE)
- Employee and Department management (add, edit, delete, list)
- Recruitment - Job posting and Applicants with status flow APPLIED to HIRED
- Leave and Attendance - apply leave, approve/reject, mark attendance
- Payroll - run payroll with basic + hra + allowance - deductions = net salary
- Performance - add review with rating 1-5, goals and feedback
- Dashboard - total employees, departments, jobs, applicants, leaves, payrolls, reviews
- Global error handling and simple validations

## Project Structure
```
backend/ - Spring Boot app (controller, service, repository, entity, security)
frontend/ - Angular app (features: auth, employee, recruitment, leave, payroll, performance, dashboard)
docker-compose.yml - Oracle XE DB
```

## Quick Start

### Prerequisites
Java 21, Maven 3.9+, Node 20+, Docker

### 1. Database (Oracle with Docker)
```bash
docker-compose up -d oracle-db
# JDBC URL: jdbc:oracle:thin:@localhost:1521/XEPDB1
# Username: hrgenius / Password: HrGenius123
# check: docker logs hrgenius-oracle
```

### 2. Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
# API: http://localhost:8080/api/v1
# Swagger: http://localhost:8080/swagger-ui.html
```

### 3. Frontend
```bash
cd frontend
npm install
ng serve --port 4200
# App: http://localhost:4200
# Login: /auth/login -> redirects to /dashboard
```

### 4. Full Docker (optional)
```bash
docker-compose up --build -d
# frontend http://localhost:4200
# backend http://localhost:8080
```

## Default Users (created on first run)
- Admin: admin@hrgenius.com / Admin@123
- HR Manager: hr@hrgenius.com / Hr@123
- Manager: manager@hrgenius.com / Manager@123
- Employee: emp@hrgenius.com / Emp@123

## Main APIs
- POST /api/v1/auth/login
- GET, POST, PUT, DELETE /api/v1/employees
- GET, POST /api/v1/departments
- GET, POST /api/v1/recruitment/jobs and /applicants
- GET, POST, PUT /api/v1/leaves and /attendance
- GET, POST /api/v1/payrolls and /payrolls/run
- GET, POST, PUT /api/v1/performance
- GET /api/v1/analytics/stats

All APIs need header `Authorization: Bearer <token>` except login.

## Routes (Frontend)
`/`, `/dashboard`, `/employees`, `/recruitment`, `/leave`, `/payroll`, `/performance`, `/auth/login`
Guards used for protected routes, JWT interceptor adds token.

## Config (no hard code)
- Backend config in `backend/src/main/resources/application.properties` - uses `app.jwt.secret` and `app.jwt.expiration-ms`
- Frontend API url in `frontend/src/environments/environment.ts` - `apiUrl`
- Change values via environment variables

## Testing
```bash
cd backend
mvn test
```

## Git Remote
https://github.com/kunalkumar2142/hrgenious.git
