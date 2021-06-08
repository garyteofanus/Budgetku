package com.budgetku.core.state;

public class ExpiredBudgetState implements BudgetState {

    @Override
    public String getSummary() {
        return "Budget has expired.";
    }
}