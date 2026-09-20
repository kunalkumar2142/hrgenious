package com.hrgenius.controller;

import com.hrgenius.entity.Payroll;
import com.hrgenius.service.PayrollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payrolls")
public class PayrollController {

    private final PayrollService service;

    public PayrollController(PayrollService service) {
        this.service = service;
    }

    @GetMapping
    public List<Payroll> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Payroll getOne(@PathVariable Long id) { return service.getById(id); }

    @PostMapping("/run")
    public Payroll run(@RequestBody Payroll payroll) { return service.runPayroll(payroll); }
}
