package com.budgetku.budgetState;

public class NormalBudgetState implements BudgetState{

    @Override
    public String getSummary() {
        return "Current budget value is normal!";
    }
}
