package com.budgetku.core.budgetkuobserver;

import java.util.ArrayList;

import com.budgetku.model.Budget;

public class DanaKeluarSubscriber {
    ArrayList<Budget> budgetList = new ArrayList<>();
    DanaKeluarPublisher danaKeluarPublisher;

    public DanaKeluarSubscriber(DanaKeluarPublisher danaKeluarPublisher) {
        this.danaKeluarPublisher = danaKeluarPublisher;
        this.danaKeluarPublisher.addSubscriber(this);
    }

    public void add(Budget budget) {
        this.budgetList.add(budget);
    }

    public void update() {
        int nominalDanaKeluar = this.danaKeluarPublisher.getDanaKeluar().getNominal();
        for (Budget budget: budgetList) {
            budget.setNominal(budget.getNominal() - nominalDanaKeluar);
        }
    }
}
