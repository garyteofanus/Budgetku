package com.budgetku.budgetstate;

public class ExpiredBudgetState implements BudgetState {

    @Override
    public String getSummary() {
        return "This budget has expired!";
    }
}