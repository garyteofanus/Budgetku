package com.budgetku.budgetstate;

public class NormalBudgetState implements BudgetState {

    @Override
    public String getSummary() {
        return "Budget still available";
    }
}
