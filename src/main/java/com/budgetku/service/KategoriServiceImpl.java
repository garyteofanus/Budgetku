package com.budgetku.service;

import com.budgetku.model.Kategori;
import com.budgetku.model.User;
import com.budgetku.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class KategoriServiceImpl implements KategoriService{
    @Autowired
    private KategoriRepository kategoriRepository;

    @Override
    public Iterable<Kategori> getListKategoriByUser(User user) {
        return kategoriRepository.findByUser(user);
    }

    @Override
    public Kategori createKategori(String namaKategori, String deskripsi, User user) {
        Kategori kategori = new Kategori(namaKategori,deskripsi,user);
        kategoriRepository.save(kategori);
        return kategori;
    }

    @Override
    public void deleteKategori(long idKategori) {
        kategoriRepository.deleteById(idKategori);
    }
}