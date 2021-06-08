package com.budgetku.model;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kategori")
@Data
@NoArgsConstructor
public class Kategori {

    @Id
    @Column(name = "id_kategori")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idKategori;

    @Column(name = "namaKategori")
    private String namaKategori;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "user_budget")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "kategori")
    @JsonIgnore
    private List<DanaKeluar> danaKeluarList;

    @ManyToMany(mappedBy = "kategoriList")
    private List<Budget> budgetList;

    public Kategori(String namaKategori, String deskripsi, User user) {
        this.namaKategori = namaKategori;
        this.deskripsi = deskripsi;
        this.user = user;
    }

    public long getId() {
        return idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public User getUser() {
        return user;
    }
}
