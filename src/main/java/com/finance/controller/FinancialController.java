package com.finance.controller;

import com.finance.entity.FinancialRecord;
import com.finance.service.FinancialService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class FinancialController {

    private final FinancialService service;

    public FinancialController(FinancialService service) {
        this.service = service;
    }

    @PostMapping
    public FinancialRecord save(@RequestBody FinancialRecord r) {
        return service.save(r);
    }

    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }
}