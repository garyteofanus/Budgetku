package com.budgetku.service;

import com.budgetku.core.observer.DanaKeluarSubscriber;
import com.budgetku.model.Budget;
import com.budgetku.model.User;
import com.budgetku.repository.BudgetRepository;
import com.budgetku.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private final BudgetRepository budgetRepository;

    @Autowired
    private final DanaKeluarService danaKeluarService;

    private final DanaKeluarSubscriber danaKeluarSubscriber;

    @Autowired
    private UserRepository userRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository, DanaKeluarService danaKeluarService) {
        this.budgetRepository = budgetRepository;
        this.danaKeluarService = danaKeluarService;
        this.danaKeluarSubscriber = new DanaKeluarSubscriber(this.danaKeluarService.getDanaKeluarPublisher(), this.budgetRepository);
    }

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
    public Iterable<Map<Budget, String[]>> getListBudgetAndStateByUser(String email) {
        List<Map<Budget, String[]>> res = new ArrayList<>();
        for (Budget budget: budgetRepository.findAll()) {
            if (budget.getUser().getEmail().equals(email)) {
                System.out.println(budget.getState());
                res.add(new HashMap<Budget, String[]>() {{
                    put(budget, new String[]{budget.getState().getSummary(), budget.getState().getDeletable()});
                }});
            }
        }
        return res;
    }

    @Override
    public Budget createBudget(Budget budget, String userEmail) {
        User pengguna = userRepository.findByEmail(userEmail);
        budget.setUser(pengguna);
        budgetRepository.save(budget);
        return budget;
    }

    @Override
    public Budget updateBudget(int id) {
        return null;
    }

    @Override
    public void deleteBudgetById(int id) {
        budgetRepository.deleteById((long)id);
    }
}

    