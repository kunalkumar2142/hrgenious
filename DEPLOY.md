# Deploy Guide - HRGenius

Simple steps to run full project

## Backend
cd backend
mvn clean install
mvn spring-boot:run
# http://localhost:8080/swagger-ui.html

## Frontend
cd frontend
npm install
ng serve
# http://localhost:4200

## Docker DB
docker-compose up -d

Test login: admin@hrgenius.com / Admin@123
