package com.budgetku.service;

import com.budgetku.model.DanaKeluar;

public interface DanaKeluarService {
    DanaKeluar createDanaKeluar(Integer nominal, String tanggal, String deskripsi,
                                String userEmail);
}
