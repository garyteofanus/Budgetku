package com.budgetku.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "kategori")
@Data
@NoArgsConstructor
public class Kategori {

    @Id
    @Column(name = "id_kategori", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idKategori;

    @Column(name = "namaKategori")
    private String namaKategori;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name="user_budget")
    private User user;

    public Kategori(String namaKategori, String deskripsi, User user) {
        this.namaKategori = namaKategori;
        this.deskripsi = deskripsi;
        this.user = user;
    }

    public long getId() {
        return idKategori;
    }

    public String getNamaKategori(){
        return namaKategori;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public User getUser(){
        return user;
    }
}
