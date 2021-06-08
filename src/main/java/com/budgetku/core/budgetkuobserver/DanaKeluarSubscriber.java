package com.budgetku.core.budgetkuobserver;

import com.budgetku.model.Budget;
import com.budgetku.budgetstate.*;
import java.util.ArrayList;
import java.util.List;

public class DanaKeluarSubscriber {
    private List<Budget> budgetList = new ArrayList<>();
    private DanaKeluarPublisher danaKeluarPublisher;

    public DanaKeluarSubscriber(DanaKeluarPublisher danaKeluarPublisher) {
        this.danaKeluarPublisher = danaKeluarPublisher;
        this.danaKeluarPublisher.addSubscriber(this);
    }

    public void add(Budget budget) {
        this.budgetList.add(budget);
    }

    public List<Budget> getBudgetList() {
        return this.budgetList;
    }

    private void checkState(Budget budget) {
        if (budget.getNominal() <= 0) {
            budget.changeState(new NegativeBudgetState());
        }
    }

    public void update() {
        int nominalDanaKeluar = this.danaKeluarPublisher.getDanaKeluar().getNominal();
        for (Budget budget : budgetList) {
            budget.setNominal(budget.getNominal() - nominalDanaKeluar);
            checkState(budget);
        }
    }
}
