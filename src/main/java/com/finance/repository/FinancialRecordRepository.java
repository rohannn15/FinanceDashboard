package com.finance.repository;

import com.finance.entity.*;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    // Total Income
    @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = com.finance.entity.Type.INCOME")
    Double getTotalIncome();

    // Total Expense
    @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = com.finance.entity.Type.EXPENSE")
    Double getTotalExpense();

    // Category-wise totals
    @Query("SELECT f.category, SUM(f.amount) FROM FinancialRecord f GROUP BY f.category")
    List<Object[]> getCategoryTotals();

    // Recent 5 records
    List<FinancialRecord> findTop5ByOrderByDateDesc();

    // Monthly Income
    @Query("SELECT MONTH(f.date), SUM(f.amount) FROM FinancialRecord f WHERE f.type = com.finance.entity.Type.INCOME GROUP BY MONTH(f.date)")
    List<Object[]> getMonthlyIncome();

    // Monthly Expense
    @Query("SELECT MONTH(f.date), SUM(f.amount) FROM FinancialRecord f WHERE f.type = com.finance.entity.Type.EXPENSE GROUP BY MONTH(f.date)")
    List<Object[]> getMonthlyExpense();
}