package com.budgetku.service;

import com.budgetku.model.Budget;

public interface BudgetService {

    Iterable<Budget> getListBudgetByUser(String email);

    Budget createBudget(Budget budget, String userEmail);

    String getSummary();
}
