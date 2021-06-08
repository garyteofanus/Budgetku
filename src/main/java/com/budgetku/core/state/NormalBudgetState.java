package com.budgetku.core.state;

public class NormalBudgetState implements BudgetState {

    @Override
    public String getSummary() {
        return "Budget still available";
    }

    @Override
    public String getUpdatable() {
        return "updatable";
    }

    @Override
    public String getDeletable() {
        return "deletable";
    }

}
