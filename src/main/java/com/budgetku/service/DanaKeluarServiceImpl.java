package com.budgetku.service;

import com.budgetku.core.budgetkuobserver.DanaKeluarPublisher;
import com.budgetku.model.DanaKeluar;
import com.budgetku.model.User;
import com.budgetku.repository.DanaKeluarRepository;
import com.budgetku.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DanaKeluarServiceImpl implements DanaKeluarService {

    private final DanaKeluarRepository danaKeluarRepository;
    private final UserRepository userRepository;

    private final DanaKeluarPublisher danaKeluarPublisher;

    public DanaKeluarServiceImpl(DanaKeluarRepository danaKeluarRepository,
                                 UserRepository userRepository) {
        this.danaKeluarRepository = danaKeluarRepository;
        this.userRepository = userRepository;
        this.danaKeluarPublisher = new DanaKeluarPublisher();
    }

    @Override
    public DanaKeluar createDanaKeluar(DanaKeluar danaKeluar, String userEmail) {
        User pengguna = userRepository.findByEmail(userEmail);
        danaKeluar.setUser(pengguna);
        danaKeluarPublisher.addDanaKeluar(danaKeluar);
        danaKeluarRepository.save(danaKeluar);
        return danaKeluar;
    }

    public DanaKeluarPublisher getDanaKeluarPublisher() {
        return danaKeluarPublisher;
    }
}
