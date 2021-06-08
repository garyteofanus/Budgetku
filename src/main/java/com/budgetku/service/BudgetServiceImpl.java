package com.budgetku.service;

import com.budgetku.core.observer.DanaKeluarSubscriber;
import com.budgetku.core.state.BudgetState;
import com.budgetku.core.state.NormalBudgetState;
import com.budgetku.model.Budget;
import com.budgetku.model.User;
import com.budgetku.repository.BudgetRepository;
import com.budgetku.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetState budgetState;

    private final DanaKeluarSubscriber danaKeluarSubscriber;

    @Autowired
    private final BudgetRepository budgetRepository;

    @Autowired
    private final DanaKeluarService danaKeluarService;

    @Autowired
    private UserRepository userRepository;

    @Override
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
    public String getSummary() {
        return budgetState.getSummary();
    }

    public BudgetServiceImpl(BudgetRepository budgetRepository,
                             DanaKeluarService danaKeluarService) {
        this.budgetState = new NormalBudgetState();
        this.budgetRepository = budgetRepository;
        this.danaKeluarService = danaKeluarService;
        this.danaKeluarSubscriber =
            new DanaKeluarSubscriber(this.danaKeluarService.getDanaKeluarPublisher());
    }
}

    