package com.budgetku.controller;

import com.budgetku.model.DanaKeluar;
import com.budgetku.model.Role;
import com.budgetku.model.User;
import com.budgetku.repository.UserRepository;
import com.budgetku.service.DanaKeluarService;
import com.budgetku.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = DanaKeluarController.class)
public class DanaKeluarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    DanaKeluarService danaKeluarService;

    @Mock
    private UserRepository userRepository;

    private DanaKeluar danaKeluar1;
    private User user;

    @BeforeEach
    public void setUp() throws Exception {
        user = new User(
                "nama depan",
                "nama belakang",
                "email@mail.com",
                "password",
                Collections.singleton(new Role("ROLE_USER"))
        );
        userRepository.save(user);

        danaKeluar1 = new DanaKeluar(
                1000,
                "2021-06-21",
                "ini desc");
    }

//    void testControllerCreateDanakeluar() throws Exception {
//        danaKeluar1.setId(1L);
//        when(danaKeluarService.createDanaKeluar(danaKeluar1, user.getEmail())).thenReturn(danaKeluar1);
//
//        mockMvc.perform(post("/danakeluar/create"))
//    }
}
