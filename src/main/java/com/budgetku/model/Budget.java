package com.budgetku.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "budget")
@Data
@NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nominal")
    private Long nominal;

    @Column(name = "tanggal")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime tanggal;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "budget_category",
            joinColumns = @JoinColumn(name = "budget_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private List<Category> categoryList;

    @ManyToOne
    @JoinColumn(name = "user_budget")
    private User user;

    public Budget(Long nominal, LocalDateTime tanggal, String deskripsi, User user) {
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.user = user;
    }

    public Budget(Long nominal, String tanggal, String deskripsi, User user) {
        this(
                nominal,
                LocalDateTime.parse(tanggal, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                deskripsi,
                user
        );
    }

    // Observer Subscriber's update method called from DanaKeluarService
    public void update(int id, DanaKeluar danaKeluar) {
        if (this.id == id) {
            this.nominal -= danaKeluar.getNominal();
        }
    }
}
