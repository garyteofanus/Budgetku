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

    private User pengguna;
    private DanaKeluar danaKeluar1;

    @BeforeEach
    public void setUp() throws Exception {
        pengguna = new User(
                "nama depan",
                "nama belakang",
                "email@mail.com",
                "password",
                Collections.singleton(new Role("ROLE_USER"))
        );
        userRepository.save(pengguna);

        danaKeluar1 = new DanaKeluar(
                1000,
                "2021-06-21",
                "ini desc");
    }

    @Test
    public void testCreateDanaKeluar() {
        danaKeluarServiceImpl.createDanaKeluar(danaKeluar1, pengguna.getEmail());
        Assertions.assertTrue(true);
    }
}
