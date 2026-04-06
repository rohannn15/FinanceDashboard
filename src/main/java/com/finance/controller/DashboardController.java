package com.finance.controller;

import com.finance.entity.FinancialRecord;
import com.finance.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    // ✅ Main Dashboard API (BEST)
    @GetMapping
    public Map<String, Object> getDashboard() {

        Map<String, Object> data = new HashMap<>();

        data.put("totalIncome", service.getTotalIncome());
        data.put("totalExpense", service.getTotalExpense());
        data.put("balance", service.getBalance());
        data.put("categories", service.getCategoryTotals());
        data.put("recent", service.getRecentTransactions());
        data.put("monthly", service.getMonthlyTrends());

        return data;
    }

   

    @GetMapping("/income")
    public double getIncome() {
        return service.getTotalIncome();
    }

    @GetMapping("/expense")
    public double getExpense() {
        return service.getTotalExpense();
    }

    @GetMapping("/balance")
    public double getBalance() {
        return service.getBalance();
    }

    @GetMapping("/categories")
    public Map<String, Double> getCategories() {
        return service.getCategoryTotals();
    }

    @GetMapping("/recent")
    public List<FinancialRecord> getRecent() {
        return service.getRecentTransactions();
    }

    @GetMapping("/monthly")
    public Map<String, Double> getMonthly() {
        return service.getMonthlyTrends();
    }
}