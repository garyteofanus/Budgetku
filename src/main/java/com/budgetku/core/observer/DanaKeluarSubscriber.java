package com.budgetku.core.observer;

import com.budgetku.model.Budget;
import com.budgetku.repository.BudgetRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.budgetku.core.state.NegativeBudgetState;
import com.budgetku.core.state.NormalBudgetState;

import java.util.ArrayList;
import java.util.List;

public class DanaKeluarSubscriber {

    @Autowired
    private final BudgetRepository budgetRepository;

    private final DanaKeluarPublisher danaKeluarPublisher;

    public DanaKeluarSubscriber(DanaKeluarPublisher danaKeluarPublisher, BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
        this.danaKeluarPublisher = danaKeluarPublisher;
        this.danaKeluarPublisher.addSubscriber(this);
    }

    private void checkState(Budget budget) {
        if (budget.getNominal() <= 0) {
            budget.changeState(new NegativeBudgetState());
        } else if (budget.getNominal() > 0) {
            budget.changeState(new NormalBudgetState());
        }
    }

    public void update(String userEmail) {
        int nominalDanaKeluar = this.danaKeluarPublisher.getDanaKeluar().getNominal();
        Budget budgetDanaKeluar = this.danaKeluarPublisher.getDanaKeluar().getBudget();
        for (Budget budget : budgetRepository.findAll()) {
            if (budget.getUser().getEmail().equals(userEmail) && budget.equals(budgetDanaKeluar)) {
                budget.setNominal(budget.getNominal() - nominalDanaKeluar);
                checkState(budget);
            }
        }
    }
}
