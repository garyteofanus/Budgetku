package com.budgetku.service;

import java.util.Map;

import com.budgetku.model.Budget;

public interface BudgetService {

    Iterable<Map<Budget, String[]>> getListBudgetByUser(String email);

    Budget createBudget(Budget budget, String userEmail);

    Budget getBudgetById(int id);

    Budget updateBudget(int id);

    void deleteBudgetById(int id);
}
