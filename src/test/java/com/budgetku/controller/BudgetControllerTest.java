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


@WebMvcTest(controllers = MainController.class)
public class BudgetControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @MockBean
    BudgetService budgetService;

    // @Test
    // public void testGetBudgetStatusShouldRedirectWhenNotLoggedIn() throws Exception {
    //     this.mvc.perform(get("/budget/")).andDo(print()).andExpect(status().isFound());
    //     // this.mvc.perform(get("/budget/")).andDo(print()).andExpect(status().isOk());
    // }

    // @Test
    // public void testGetListBudgetStatusShouldRedirectWhenNotLoggedIn() throws Exception {
    //     this.mvc.perform(get("/budget/list-budget")).andDo(print()).andExpect(status().isFound());
    //     // this.mvc.perform(get("/budget/list-budget")).andDo(print()).andExpect(status().isOk());
    // }
}

