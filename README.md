# HRGenius - HR Management System (HRMS) - P_016

Full Stack HRMS: Employee data, Recruitment/Onboarding, Payroll, Performance & Analytics.

**Stack:** Java 21, Spring Boot 3.2.5, Spring Security JWT, Hibernate/JPA, Oracle DB 21c XE, Angular 17, Angular Material

## Quick Start

### 1. Oracle DB (Docker)
```bash
docker-compose up -d oracle-db
# JDBC URL: jdbc:oracle:thin:@localhost:1521/XEPDB1
# Username: hrgenius / Password: HrGenius123  (SYS: system/HrGenius123)
# Check health: docker logs hrgenius-oracle
```

### 2. Backend
```bash
cd backend
# Requires Maven 3.9+ and Java 17/21
mvn clean install
mvn spring-boot:run
# API: http://localhost:8080/api
# Swagger: http://localhost:8080/swagger-ui.html
```

### 3. Frontend
```bash
cd frontend
npm install
ng serve --port 4200
# App: http://localhost:4200
```

## Default Credentials (Seed Data)
- Admin: admin@hrgenius.com / Admin@123
- HR Manager: hr@hrgenius.com / Hr@123

## API Prefix
All backend APIs under `/api/v1/*` secured with JWT `Authorization: Bearer <token>`

## Git Remote
https://github.com/kunalkumar2142/hrgenious.git
