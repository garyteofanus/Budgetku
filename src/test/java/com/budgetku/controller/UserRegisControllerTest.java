package com.budgetku.controller;


import com.budgetku.dto.UserRegistrationDto;
import com.budgetku.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(controllers = UserRegisController.class)
public class UserRegisControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @Test
    public void testGetMappingShouldReturnRegistrationForm() throws Exception {
        this.mvc.perform(get("/register")).andDo(print()).andExpect(status().isOk());
    }
}
