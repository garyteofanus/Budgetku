package com.budgetku.service;

import com.budgetku.model.Kategori;
import com.budgetku.model.User;

public interface KategoriService {

    Iterable<Kategori> getListKategoriByUser(User user);

    Kategori createKategori(String namaKategori, String deskripsi, User user);

    void deleteKategori(long idKategori);
}