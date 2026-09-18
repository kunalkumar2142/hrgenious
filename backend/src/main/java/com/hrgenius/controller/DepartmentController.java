package com.hrgenius.controller;

import com.hrgenius.entity.Department;
import com.hrgenius.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @PostMapping
    public Department create(@RequestBody Department dept) {
        return departmentRepository.save(dept);
    }
}
