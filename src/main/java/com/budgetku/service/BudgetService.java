package com.budgetku.service;

import com.budgetku.model.Budget;

public interface BudgetService {
    Iterable<Budget> getListBudget();

    Iterable<Budget> getListBudgetByUser(int id);

    Budget createBudget(Budget budget, String userEmail);

    Budget getBudgetById(int id);

    Budget updateBudget(int id);

    void deleteBudgetById(int id);

    String getSummary();
}
