package com.budgetku.service;

import com.budgetku.repository.BudgetRepository;

import com.budgetku.model.Budget;

import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    @Override
    public Iterable<Budget> getListBudget() {
        return budgetRepository.findAll();
    }

    @Override
    public Budget getBudgetById(int id) {
        return budgetRepository.findById(id);
    }

    @Override
    public Budget updateBudget(int id) {
        return null;
    }

    @Override
    public void deleteBudgetById(int id) {
        budgetRepository.deleteById(id);
    }

    @Override
    public String getSummary() {
        return null;
    }
}

    