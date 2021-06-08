package com.budgetku.service;

import com.budgetku.model.Role;
import com.budgetku.model.User;
import com.budgetku.repository.DanaKeluarRepository;
import com.budgetku.repository.UserRepository;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DanaKeluarServiceImplTest {

    @Mock
    private DanaKeluarRepository danaKeluarRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DanaKeluarServiceImpl danaKeluarServiceImpl;

    @BeforeEach
    public void setUp(){
        User pengguna = new User(
                "nama depan",
                "nama belakang",
                "email@mail.com",
                "password",
                Collections.singleton(new Role("ROLE_USER"))
        );
        userRepository.save(pengguna);
    }

    @Test
    public void testCreateDanaKeluar() {
        danaKeluarServiceImpl.createDanaKeluar(
                1000,
                "07/05/2021 16:48",
                "sebuah deskripsi",
                "email@mail.com"
        );
        Assertions.assertTrue(true);
    }
}
