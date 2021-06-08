package com.budgetku.core.state;

public class NormalBudgetState implements BudgetState {

    @Override
    public String getSummary() {
        return "Budget still available";
    }
}
