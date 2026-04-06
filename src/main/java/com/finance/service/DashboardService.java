package com.finance.service;

import com.finance.entity.FinancialRecord;
import com.finance.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final FinancialRecordRepository repo;

    public DashboardService(FinancialRecordRepository repo) {
        this.repo = repo;
    }

    // Get all records once (optimization)
    private List<FinancialRecord> getRecords() {
        return repo.findAll();
    }

    // Total Income
    public double getTotalIncome() {
        return getRecords().stream()
                .filter(r -> r.getType() != null && r.getType().name().equalsIgnoreCase("INCOME"))
                .mapToDouble(r -> r.getAmount() != null ? r.getAmount() : 0.0)
                .sum();
    }

    // Total Expense
    public double getTotalExpense() {
        return getRecords().stream()
                .filter(r -> r.getType() != null && r.getType().name().equalsIgnoreCase("EXPENSE"))
                .mapToDouble(r -> r.getAmount() != null ? r.getAmount() : 0.0)
                .sum();
    }

    // Balance
    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    // Category-wise totals (category is String)
    public Map<String, Double> getCategoryTotals() {
        return getRecords().stream()
                .filter(r -> r.getCategory() != null)
                .collect(Collectors.groupingBy(
                        FinancialRecord::getCategory,
                        Collectors.summingDouble(r -> r.getAmount() != null ? r.getAmount() : 0.0)
                ));
    }

    // Recent transactions (last 5)
    public List<FinancialRecord> getRecentTransactions() {
        return getRecords().stream()
                .filter(r -> r.getDate() != null)
                .sorted(Comparator.comparing(FinancialRecord::getDate).reversed())
                .limit(5)
                .toList();
    }

    // Monthly trends
    public Map<String, Double> getMonthlyTrends() {
        return getRecords().stream()
                .filter(r -> r.getDate() != null)
                .collect(Collectors.groupingBy(
                        r -> r.getDate().getMonth().toString(),
                        Collectors.summingDouble(r -> r.getAmount() != null ? r.getAmount() : 0.0)
                ));
    }
}