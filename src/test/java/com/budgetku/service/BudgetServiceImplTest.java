package com.budgetku.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.budgetku.model.Role;
import com.budgetku.model.User;
import com.budgetku.repository.BudgetRepository;
import com.budgetku.repository.UserRepository;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class BudgetServiceImplTest {

    @Autowired
    private BudgetRepository budgetRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private BudgetServiceImpl budgetService;

    @BeforeEach
    public void setUp(){
        User pengguna = new User(
                "Depan",
                "Belakang",
            "mail@mail.com",
            "password",
            Collections.singletonList(new Role("ROLE_USER"))
        );
    }

    @Test
    public void whenGetSummaryIsCalledItShouldReturnSummary() {
        assertEquals("Summary", budgetService.getSummary());
    }

//    @Test
//    public void getListBudgetShouldReturnListOfBudgets() {
//        Budget mockBudgetA = new Budget();
//        Budget mockBudgetB = new Budget();
//
//        ArrayList<Budget> listOfBudget = new ArrayList<>();
//        listOfBudget.add(mockBudgetA);
//        listOfBudget.add(mockBudgetB);
//
//
//    }

}
