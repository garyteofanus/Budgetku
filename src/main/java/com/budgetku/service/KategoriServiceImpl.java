package com.budgetku.service;

import com.budgetku.model.Kategori;
import com.budgetku.model.User;
import com.budgetku.repository.KategoriRepository;
import com.budgetku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategoriServiceImpl implements KategoriService {
    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<Kategori> getListKategoriByUser(String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        return kategoriRepository.findByUser(user);
    }

    @Override
    public Kategori createKategori(String namaKategori, String deskripsi, String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        Kategori kategori = new Kategori(namaKategori, deskripsi, user);
        kategoriRepository.save(kategori);
        return kategori;
    }

    @Override
    public void deleteKategori(long idKategori) {
        kategoriRepository.deleteById(idKategori);
    }
}