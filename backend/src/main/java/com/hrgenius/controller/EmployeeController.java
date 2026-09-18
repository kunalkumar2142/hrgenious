package com.hrgenius.controller;

import com.hrgenius.entity.Department;
import com.hrgenius.entity.Employee;
import com.hrgenius.dto.EmployeeRequest;
import com.hrgenius.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeRequest req) {
        return employeeService.create(req);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody EmployeeRequest req) {
        return employeeService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/departments")
    public List<Department> getDepts() {
        return employeeService.getAllDepartments();
    }
}
