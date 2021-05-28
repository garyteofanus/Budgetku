package com.budgetku.service;

import com.budgetku.core.budgetkuobserver.DanaKeluarPublisher;
import com.budgetku.core.budgetkuobserver.DanaKeluarSubscriber;
import com.budgetku.model.Budget;
import com.budgetku.model.User;
import com.budgetku.repository.BudgetRepository;
import com.budgetku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private final BudgetRepository budgetRepository;
    private final DanaKeluarSubscriber danaKeluarSubscriber;

    // @Autowired
    // private DanaKeluarPublisher danaKeluarPublisher;
    @Autowired
    private UserRepository userRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
        this.danaKeluarSubscriber = new DanaKeluarSubscriber(new DanaKeluarPublisher());
    }

    @Override
    public Iterable<Budget> getListBudget() {
        return budgetRepository.findAll();
    }

    @Override
    public Budget createBudget(Budget budget, String userEmail) {
        User pengguna = userRepository.findByEmail(userEmail);
        budget.setUser(pengguna);
        danaKeluarSubscriber.add(budget);
        budgetRepository.save(budget);
        return budget;
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
        return "Summary";
    }
}

    