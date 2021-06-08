package com.budgetku.service;

import java.util.Map;

import com.budgetku.model.Budget;

public interface BudgetService {

    Iterable<Budget> getListBudgetByUser(String email);

    Iterable<Map<Budget, String[]>> getListBudgetAndStateByUser(String email);

    Budget createBudget(Budget budget, String userEmail);

    Budget updateBudget(int id);

    void deleteBudgetById(int id);
}
