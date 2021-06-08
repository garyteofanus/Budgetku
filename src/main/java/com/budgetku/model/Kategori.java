package com.budgetku.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.ToString;

@Entity
@Table(name = "kategori")
@Data
@NoArgsConstructor
@ToString
public class Kategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "kategori")
    @JsonIgnore
    private List<Budget> budgetList;

    public Kategori(String nama, String deskripsi, User user) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.user = user;
    }
}
