package com.budgetku.service;

import com.budgetku.model.Kategori;

public interface KategoriService {

    Iterable<Kategori> getListKategoriByUser(String userEmail);

    Kategori createKategori(Kategori kategori, String userEmail);

    void deleteKategori(long idKategori);
}