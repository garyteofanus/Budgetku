package com.budgetku.service;

import com.budgetku.core.observer.DanaKeluarSubscriber;
import com.budgetku.core.state.NegativeBudgetState;
import com.budgetku.core.state.NormalBudgetState;
import com.budgetku.model.Budget;
import com.budgetku.model.User;
import com.budgetku.repository.BudgetRepository;
import com.budgetku.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    private final DanaKeluarService danaKeluarService;

    private final DanaKeluarSubscriber danaKeluarSubscriber;

    @Autowired
    private UserRepository userRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository, DanaKeluarService danaKeluarService) {
        this.budgetRepository = budgetRepository;
        this.danaKeluarService = danaKeluarService;
        this.danaKeluarSubscriber = new DanaKeluarSubscriber(this.danaKeluarService.getDanaKeluarPublisher(), this.budgetRepository);
    }

    private void checkState(Budget budget) {
        System.out.println(budget.getNominal());
        if (budget.getNominal() <= 0) {
            budget.setState(new NegativeBudgetState());
        } else if (budget.getNominal() > 0) {
            budget.setState(new NormalBudgetState());
        }
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
    public ArrayList<ArrayList<Object>> getListBudgetAndStateByUser(String email) {
        // ObjectMapper objectEntityMapper = new ObjectMapper();
        // objectEntityMapper.registerModule(new Hibernate5Module());
        // objectEntityMapper.setSerializationInclusion(Include.NON_NULL);

        ArrayList<ArrayList<Object>> res = new ArrayList<ArrayList<Object>>();
        System.out.println("Getting");
        for (Budget budget: budgetRepository.findAll()) {
            if (budget.getUser().getEmail().equals(email)) {
                ArrayList<Object> inside = new ArrayList<>();
                inside.add(budget);
                if (budget.getState() == null) {
                    if (budget.getNominal() <= 0) inside.add("On Limit!");
                    else inside.add("Available");
                }
                inside.add("Available");
                res.add(inside);
            }
        }
        return res;
    }

    @Override
    public Budget createBudget(Budget budget, String userEmail) {
        User pengguna = userRepository.findByEmail(userEmail);
        budget.setUser(pengguna);
        budgetRepository.save(budget);
        System.out.println("Adding");
        System.out.println(budget.getState());
        return budget;
    }

    @Override
    public Budget getBudgetById(Long id) {
        if (budgetRepository.findById(id).isPresent()) {
            return budgetRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Budget updateBudget(int id) {
        return null;
    }

    @Override
    public void deleteBudgetById(int id) {
        budgetRepository.deleteById((long) id);
    }
}

    