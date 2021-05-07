package com.budgetku.controller;

import com.budgetku.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @Test
    public void testGetLoginStatusShouldOk() throws Exception {
        this.mvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testGetHomeStatusShouldRedirected() throws Exception {
        this.mvc.perform(get("/")).andDo(print()).andExpect(status().isFound());
    }

    @Test
    @WithMockUser
    public void testGetHomeStatusShouldOkWithLoggedInUser() throws Exception {
        this.mvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }
}
