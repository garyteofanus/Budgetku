package com.budgetku.repository;

import com.budgetku.model.DanaKeluar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanaKeluarRepository extends JpaRepository<DanaKeluar, Long> {

}
