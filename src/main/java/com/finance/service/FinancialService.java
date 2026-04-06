package com.finance.service;

import com.finance.entity.FinancialRecord;
import com.finance.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service   // ✅ VERY IMPORTANT
public class FinancialService {

    private final FinancialRecordRepository repo;

    public FinancialService(FinancialRecordRepository repo) {
        this.repo = repo;
    }

    public FinancialRecord save(FinancialRecord r) {
        return repo.save(r);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public Double income() {
        return repo.getTotalIncome() != null ? repo.getTotalIncome() : 0;
    }

    public Double expense() {
        return repo.getTotalExpense() != null ? repo.getTotalExpense() : 0;
    }
}