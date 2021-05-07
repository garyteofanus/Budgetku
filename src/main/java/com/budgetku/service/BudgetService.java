package com.budgetku.service;

import com.budgetku.model.Budget;

public interface BudgetService {
    Iterable<Budget> getListBudget();

    void createBudget(Budget budget);

    Budget getBudgetById(int id);
    Budget updateBudget(int id);
    void deleteBudgetById(int id);
    String getSummary();
}
