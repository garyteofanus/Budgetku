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
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="email")
    private User user;

    @Column(name = "namaKategori")
    private String namaKategori;

    @Column(name = "deskripsi")
    private String deskripsi;

    public Kategori(String namaKategori, String deskripsi, User user) {
        this.namaKategori = namaKategori;
        this.deskripsi = deskripsi;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public User getUser(){
        return user;
    }

    public String getNamaKategori(){
        return namaKategori;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

}
