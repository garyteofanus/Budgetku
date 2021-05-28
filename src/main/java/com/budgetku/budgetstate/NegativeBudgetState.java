package com.budgetku.budgetstate;

public class NegativeBudgetState implements BudgetState {
    @Override
    public String getSummary() {
        return "This budget has negative amount of money!!";
    }
}
