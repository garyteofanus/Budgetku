package com.budgetku.model;

import com.budgetku.budgetState.BudgetState;
import com.budgetku.budgetState.NormalBudgetState;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ToString
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggal;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "budget_kategori",
            joinColumns = @JoinColumn(name = "budget_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "kategori_id", referencedColumnName = "id_kategori")
    )
    private List<Kategori> kategoriList;

    @ManyToOne
    @JoinColumn(name = "user_budget")
    private User user;

    private BudgetState state;

    public Budget(Long nominal, Date tanggal, String deskripsi, User user) {
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.user = user;
        this.state = new NormalBudgetState();
    }

    // Observer Subscriber's update method called from DanaKeluarService
    public void update(int id, DanaKeluar danaKeluar) {
        if (this.id == id) {
            this.nominal -= danaKeluar.getNominal();
        }
    }

    public void changeState(BudgetState newState) {
        this.state = newState;
    }
}
