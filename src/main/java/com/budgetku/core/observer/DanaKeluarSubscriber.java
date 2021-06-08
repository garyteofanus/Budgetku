package com.budgetku.core.observer;

import com.budgetku.model.Budget;
import java.util.ArrayList;
import java.util.List;

public class DanaKeluarSubscriber {
    private final List<Budget> budgetList = new ArrayList<>();
    private final DanaKeluarPublisher danaKeluarPublisher;

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

    public void update() {
        int nominalDanaKeluar = this.danaKeluarPublisher.getDanaKeluar().getNominal();
        for (Budget budget : budgetList) {
            budget.setNominal(budget.getNominal() - nominalDanaKeluar);
        }
    }
}
