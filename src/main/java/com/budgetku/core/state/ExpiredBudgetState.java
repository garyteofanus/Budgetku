package com.budgetku.core.state;

public class ExpiredBudgetState implements BudgetState {

    @Override
    public String getSummary() {
        return "Expired";
    }

    @Override
    public String getUpdatable() {
        return "unupdatable";
    }

    @Override
    public String getDeletable() {
        return "deletable";
    }

}