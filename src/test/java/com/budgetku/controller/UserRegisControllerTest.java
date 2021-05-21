package com.budgetku.controller;


import com.budgetku.dto.UserRegistrationDto;
import com.budgetku.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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

    @Test
    public void testPostRegisterForm() throws Exception {
        UserRegistrationDto registrationDto = new UserRegistrationDto();
        registrationDto.setEmail("test@mail.com");
        registrationDto.setPassword("27a157eb1ae4");
        registrationDto.setFirstName("rafi");
        registrationDto.setLastName("dirg");

        this.mvc.perform(post("/register")
                .param("email", registrationDto.getEmail())
                .param("password", registrationDto.getPassword())
                .param("firstName", registrationDto.getFirstName())
                .param("lastName", registrationDto.getLastName())
                .with(csrf()))
                .andExpect(status().isFound());
    }
}
