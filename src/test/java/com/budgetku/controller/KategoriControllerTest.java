package com.budgetku.controller;

import com.budgetku.service.KategoriService;
import com.budgetku.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



@WebMvcTest(controllers = KategoriController.class)
public class KategoriControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    KategoriService kategoriService;

    @Test
    public void testGetBudgetStatusShouldRedirectWhenNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/kategori/")).andDo(print()).andExpect(status().isFound());
    }

}

