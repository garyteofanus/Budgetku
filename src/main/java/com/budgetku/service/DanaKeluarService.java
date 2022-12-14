package com.budgetku.service;

import com.budgetku.core.observer.DanaKeluarPublisher;
import com.budgetku.model.DanaKeluar;

public interface DanaKeluarService {
    DanaKeluar createDanaKeluar(DanaKeluar danaKeluar, String userEmail);
    DanaKeluarPublisher getDanaKeluarPublisher();
}
