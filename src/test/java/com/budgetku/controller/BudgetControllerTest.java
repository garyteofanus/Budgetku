package com.budgetku.controller;

import com.budgetku.service.BudgetService;
import com.budgetku.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BudgetController.class)
public class BudgetControllerTest {
    @MockBean
    UserService userService;
    @MockBean
    BudgetService budgetService;
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetBudgetShouldBeFound() throws Exception {
        this.mvc.perform(get("/budget")).andDo(print()).andExpect(status().isFound());
    }


//    @Test
//    public void testGetBudgetStatusShouldRedirectWhenNotLoggedIn() throws Exception {
//        User user = new User()
//        Budget budget = new Budget("Zaphod", "zaphod@galaxy.net");
//        // this.mvc.perform(get("/budget/")).andDo(print()).andExpect(status().isOk());
//    }
}
