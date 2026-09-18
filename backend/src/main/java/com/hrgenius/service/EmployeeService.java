package com.hrgenius.service;

import com.hrgenius.dto.EmployeeRequest;
import com.hrgenius.entity.Department;
import com.hrgenius.entity.Employee;
import com.hrgenius.repository.DepartmentRepository;
import com.hrgenius.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee create(EmployeeRequest req) {
        if (employeeRepository.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        Employee emp = new Employee();
        mapToEntity(req, emp);
        return employeeRepository.save(emp);
    }

    public Employee update(Long id, EmployeeRequest req) {
        Employee emp = getById(id);
        mapToEntity(req, emp);
        return employeeRepository.save(emp);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    private void mapToEntity(EmployeeRequest req, Employee emp) {
        emp.setEmpCode(req.getEmpCode());
        emp.setFirstName(req.getFirstName());
        emp.setLastName(req.getLastName());
        emp.setEmail(req.getEmail());
        emp.setPhone(req.getPhone());
        emp.setDesignation(req.getDesignation());
        emp.setDoj(req.getDoj());
        if (req.getStatus() != null) emp.setStatus(req.getStatus());
        emp.setAddress(req.getAddress());
        if (req.getDepartmentId() != null) {
            Department dept = departmentRepository.findById(req.getDepartmentId()).orElse(null);
            emp.setDepartment(dept);
        }
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
