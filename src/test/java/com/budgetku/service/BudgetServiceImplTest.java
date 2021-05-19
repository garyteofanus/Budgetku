package com.budgetku.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;

import com.budgetku.model.Budget;
import com.budgetku.model.Role;
import com.budgetku.model.User;
import com.budgetku.repository.BudgetRepository;
import com.budgetku.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BudgetServiceImplTest {    

    @Mock
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
//        DEBUG
//        userRepository.save(pengguna);
//        System.out.println(pengguna);
//        System.out.println(userRepository.findAll());
//        System.out.println(userRepository.findByEmail("mail@mail.com"));
    }

//    @Test
//    public void whenCreateBudgetIsCalledItShouldCallBudgetRepositorySave() {
//        Budget b1 = new Budget();
//        b1.setNominal((long)10000);
//
//        System.out.println(userRepository.findAll());
//
//        budgetService.createBudget(b1, "mail@mail.com");
//
//        verify(userRepository, times(1)).findByEmail("mail@mail.com");
//        verify(budgetRepository, times(1)).save(b1);
//    }
//
//    @Test
//    public void whenGetListBudgetIsCalledItShouldCallBudgetRepositoryFindAll() {
//        Budget b1 = new Budget();
//        b1.setNominal((long)10000);
//
//        budgetService.createBudget(b1, "mail@mail.com");
//        budgetService.getListBudget();
//
//        verify(budgetRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void whenDeleteBudgetIsCalledItShouldCallBudgetRepositoryDeleteById() {
//        Budget b1 = new Budget();
//        b1.setNominal((long)10000);
//
//        budgetService.createBudget(b1, "mail@mail.com");
//        budgetService.deleteBudgetById(1);
//
//        verify(budgetRepository, times(1)).deleteById(1);
//    }

    @Test
    public void whenGetSummaryIsCalledItShouldReturnSummary() {
        assertEquals("Summary", budgetService.getSummary());
    }
}