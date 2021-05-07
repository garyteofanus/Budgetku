package com.budgetku.service;

public interface BudgetService {
    Iterable<Budget> getListBudget();
    Budget getBudgetById(int id);
    Budget updateBudget(int id);
    void deleteBudgetById(int id);
    String getSummary();
}
