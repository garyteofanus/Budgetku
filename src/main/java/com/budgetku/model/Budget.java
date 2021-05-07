package com.budgetku.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "budget")
@Data
@NoArgsConstructor
public class Budget {

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

    public Budget(Integer nominal, LocalDateTime tanggal, String deskripsi) {
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
    }

    // Observer Subscriber's update method called from DanaKeluarService
    public void update(int id, DanaKeluar danaKeluar) {
        if (this.id == id) {
            this.nominal -= danaKeluar.getNominal();
        }
    }
}
