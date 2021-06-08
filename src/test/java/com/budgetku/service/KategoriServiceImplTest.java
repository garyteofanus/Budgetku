package com.budgetku.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.budgetku.model.Kategori;
import com.budgetku.model.Role;
import com.budgetku.model.User;
import com.budgetku.repository.KategoriRepository;
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
public class KategoriServiceImplTest {
    @Mock
    private KategoriRepository kategoriRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private KategoriServiceImpl kategoriService;

    private Kategori kategori;
    private User user;

    // @BeforeEach
    // public void setUp() {
    //     user = new User("dummy", "user", "dummy@gmail.com", "passworddummy",
    //         Collections.singleton(new Role("ROLE_USER")));
    //     kategori = new Kategori();
    //     kategori.setId(1L);
    //     kategori.setNama("Test");
    //     kategori.setDeskripsi("Desc");
    //     kategori.setUser(user);
    // }

    // @Test
    // public void testServiceCreateKategori(){
    //     when(kategoriService.createKategori(kategori,user.getEmail())).thenReturn(kategori);
    //     Kategori resultKategori = kategoriService.createKategori(kategori,user.getEmail() );
    //     assertEquals(kategori.getNama(), resultKategori.getNama());
    // }

    // @Test
    // public void testServiceGetListKategoriByUser(){
    //     Iterable<Kategori> listKategori = kategoriRepository.findAllByUser(user);
    //     when(kategoriService.getListKategoriByUser(user.getEmail())).thenReturn(listKategori);
    //     Iterable<Kategori> listKategoriResult = kategoriService.getListKategoriByUser(user.getEmail());
    //     Assertions.assertIterableEquals(listKategori, listKategoriResult);
    // }
    // @Test
    // void testServiceDeleteKategori() {
    //     kategoriService.deleteKategori(kategori.getId());
    //     Iterable<Kategori> listKategori = kategoriService.getListKategoriByUser(user.getEmail());
    //     int sum = 0;
    //     for(Kategori kategori:listKategori){
    //         sum++;
    //     }
    //     assertEquals(0, sum);
    // }
}
