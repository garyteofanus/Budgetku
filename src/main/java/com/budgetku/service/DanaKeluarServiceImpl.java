package com.budgetku.service;

import com.budgetku.model.DanaKeluar;
import com.budgetku.model.User;
import com.budgetku.repository.DanaKeluarRepository;
import com.budgetku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DanaKeluarServiceImpl implements DanaKeluarService {

    @Autowired
    private DanaKeluarRepository danaKeluarRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public DanaKeluar createDanaKeluar(Integer nominal, String tanggal, String deskripsi, String userEmail) {
        User pengguna = userRepository.findByEmail(userEmail);
        DanaKeluar danaKeluar = new DanaKeluar(nominal, tanggal, deskripsi, pengguna);
        danaKeluarRepository.save(danaKeluar);
        return danaKeluar;
    }
}
