package com.budgetku.service;

import com.budgetku.model.Kategori;
import com.budgetku.model.Role;
import com.budgetku.model.User;
import com.budgetku.repository.KategoriRepository;
import com.budgetku.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class KategoriServiceImplTest {
    @Mock
    private KategoriRepository kategoriRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private KategoriServiceImpl kategoriService;

    private Kategori kategori;

    @BeforeEach
    public void setUp(){
        User dummyUser = new User("dummy", "user", "dummy@gmail.com", "passworddummy", Collections.singleton(new Role("ROLE_USER")));
        kategori = new Kategori();
        kategori.setIdKategori(1);
        kategori.setNamaKategori("Test");
        kategori.setDeskripsi("Desc");
        kategori.setUser(dummyUser);
    }

    @Test
    public void testServiceCreateKategori(){
        lenient().when(kategoriService.createKategori("Test", "Desc", "dummy@gmail.com" )).thenReturn(kategori);
        Kategori resultKategori = kategoriService.createKategori("Test", "Desc", "dummy@gmail.com" );
        assertEquals(kategori.getNamaKategori(), resultKategori.getNamaKategori());

    }


}
