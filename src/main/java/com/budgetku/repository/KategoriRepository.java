package com.budgetku.repository;

import com.budgetku.model.Kategori;
import com.budgetku.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, Long> {
    Iterable<Kategori> findAllByUser(User user);
}
