package com.budgetku.repository;

import com.budgetku.model.DanaKeluar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<DanaKeluar, Long> {

}
