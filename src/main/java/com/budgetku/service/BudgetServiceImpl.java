package com.budgetku.service;

import com.budgetku.model.Budget;
import com.budgetku.repository.BudgetRepository;
import com.budgetku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private final BudgetRepository budgetRepository;

    @Autowired
    private UserRepository userRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public Iterable<Budget> getListBudget() {
        return budgetRepository.findAll();
    }

    @Override
    public void createBudget(Budget budget) {
        budgetRepository.save(budget);
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

    