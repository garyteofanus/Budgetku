package com.budgetku.core.state;

public class NegativeBudgetState implements BudgetState {
    
    @Override
    public String getSummary() {
        return "Budget has run out of limit!";
    }

    @Override
    public String getUpdatable() {
        return "updatable";
    }

    @Override
    public String getDeletable() {
        return "undeletable";
    }

}
