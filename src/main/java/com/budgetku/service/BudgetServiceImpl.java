package com.budgetku.service;

import com.budgetku.budgetstate.BudgetState;
import com.budgetku.budgetstate.NormalBudgetState;
import com.budgetku.core.budgetkuobserver.DanaKeluarPublisher;
import com.budgetku.core.budgetkuobserver.DanaKeluarSubscriber;
import com.budgetku.model.Budget;
import com.budgetku.model.User;
import com.budgetku.repository.BudgetRepository;
import com.budgetku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BudgetServiceImpl implements BudgetService {

    private BudgetState budgetState;

    @Autowired
    private final BudgetRepository budgetRepository;

    @Autowired
    private final DanaKeluarService danaKeluarService;

    private final DanaKeluarSubscriber danaKeluarSubscriber;

    @Autowired
    private UserRepository userRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository, DanaKeluarService danaKeluarService) {
        this.budgetState = new NormalBudgetState();
        this.budgetRepository = budgetRepository;
        this.danaKeluarService = danaKeluarService;
        this.danaKeluarSubscriber = new DanaKeluarSubscriber(this.danaKeluarService.getDanaKeluarPublisher());
    }

    @Override
    public Iterable<Budget> getListBudget() {
        return budgetRepository.findAll();
    }

    public Iterable<Budget> getListBudgetByUser(String email) {
        List<Budget> res = new ArrayList<>();
        for (Budget budget: budgetRepository.findAll()) {
            if (budget.getUser().getEmail().equals(email)) {
                res.add(budget);
            }
        }
        return res;
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
        return budgetState.getSummary();
    }
}

    