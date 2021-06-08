package com.budgetku.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.budgetku.model.Kategori;
import com.budgetku.model.Role;
import com.budgetku.model.User;
import com.budgetku.service.KategoriService;
import com.budgetku.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



@WebMvcTest(controllers = KategoriController.class)
public class KategoriControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    KategoriService kategoriService;

    private Kategori kategori;
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("dummy", "user", "dummy@gmail.com", "passworddummy", Collections.singleton(new Role("ROLE_USER")));
        kategori = new Kategori("Makanan", "Jajan harian", user);
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    void testControllerGetListKategori() throws Exception {
        Iterable<Kategori> listKategori = Arrays.asList(kategori);
        when(kategoriService.getListKategoriByUser(user.getEmail())).thenReturn(listKategori);

        mockMvc.perform(get("/kategori/dummy@gmail.com").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andExpect(content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].namaKategori").value(kategori.getNama()));
    }
    @Test
    void testControllerCreateKategori() throws Exception {
        kategori.setId(1L);
        when(kategoriService.createKategori(kategori, user.getEmail())).thenReturn(kategori);

        mockMvc.perform(post("/kategori/create/dummy@gmail.com")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapToJson(kategori)))
                .andExpect(status().isOk())
                .andExpect(handler().methodName("createKategori"));
    }
}

