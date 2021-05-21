package com.budgetku.budgetState;

public class ExpiredBudgetState implements BudgetState {

    @Override
    public String getSummary() {
        return "This budget has expired!";
    }
}