package com.budgetku.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Table(name = "dana_keluar")
@Data
@NoArgsConstructor
public class DanaKeluar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nominal")
    private Integer nominal;

    @Column(name = "tanggal")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tanggal;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "kategori")
    private Kategori kategori;

    @ManyToOne
    @JoinColumn(name = "user_budget")
    @JsonIgnore
    private User user;

    public DanaKeluar(Integer nominal, Date tanggal, String deskripsi, User user) {
        super();
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.user = user;
    }

    public DanaKeluar(Integer nominal, String tanggal, String deskripsi) throws ParseException {
        this(
                nominal,
                new SimpleDateFormat("yyyy-MM-dd").parse(tanggal),
                deskripsi,
                null
        );
    }
}
