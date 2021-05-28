package com.budgetku.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime tanggal;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "user_budget")
    private User user;

    public DanaKeluar(Integer nominal, LocalDateTime tanggal, String deskripsi, User user) {
        super();
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.user = user;
    }

    public DanaKeluar(Integer nominal, String tanggal, String deskripsi, User user) {
        this(
            nominal,
            LocalDateTime.parse(tanggal, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
            deskripsi,
            user
        );
    }
}
