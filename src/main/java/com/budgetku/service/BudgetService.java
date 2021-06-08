package com.budgetku.service;

import com.budgetku.model.Budget;

import java.util.ArrayList;
import java.util.Map;

public interface BudgetService {

    Iterable<Budget> getListBudgetByUser(String email);

    ArrayList<ArrayList<Object>> getListBudgetAndStateByUser(String email);

    Budget createBudget(Budget budget, String userEmail);

    Budget getBudgetById(Long id);

    Budget updateBudget(int id);

    void deleteBudgetById(int id);
}
