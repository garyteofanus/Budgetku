package com.budgetku.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kategori")
@Data
@NoArgsConstructor
public class Kategori {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "kategori")
    // Switch these 2 when adding kategori, and adding budget/adding pengeluaran
    @JsonBackReference
    // @JsonManagedReference
    private List<Budget> budgetList;

    public Kategori(String nama, String deskripsi, User user) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.user = user;
    }
}
