package com.finance.dto;

import java.util.List;
import java.util.Map;

public class DashboardDTO {

    private double totalIncome;
    private double totalExpense;
    private double netBalance;

    private Map<String, Double> categoryWiseTotals; // Category -> Amount
    private List<String> recentActivity; // Recent transaction descriptions
    private Map<String, Double> monthlyTrends; // Month-Year -> Amount

    // Getters and Setters
    public double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(double totalIncome) { this.totalIncome = totalIncome; }

    public double getTotalExpense() { return totalExpense; }
    public void setTotalExpense(double totalExpense) { this.totalExpense = totalExpense; }

    public double getNetBalance() { return netBalance; }
    public void setNetBalance(double netBalance) { this.netBalance = netBalance; }

    public Map<String, Double> getCategoryWiseTotals() { return categoryWiseTotals; }
    public void setCategoryWiseTotals(Map<String, Double> categoryWiseTotals) { this.categoryWiseTotals = categoryWiseTotals; }

    public List<String> getRecentActivity() { return recentActivity; }
    public void setRecentActivity(List<String> recentActivity) { this.recentActivity = recentActivity; }

    public Map<String, Double> getMonthlyTrends() { return monthlyTrends; }
    public void setMonthlyTrends(Map<String, Double> monthlyTrends) { this.monthlyTrends = monthlyTrends; }
}