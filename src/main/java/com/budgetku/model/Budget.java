package com.budgetku.model;

import com.budgetku.budgetstate.BudgetState;
import com.budgetku.budgetstate.NormalBudgetState;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_kategori")
    private Kategori kategori;

    @ManyToOne
    @JoinColumn(name = "user_budget")
    private User user;

    @Transient
    private BudgetState state;

    /**
     * Constructor for Budget.
     *
     * @param nominal   nominal of the budget
     * @param tanggal   expiration date for the budget
     * @param deskripsi description for the budget
     * @param user      user that perform create the budget
     */
    public Budget(Long nominal, Date tanggal, String deskripsi, User user) {
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.user = user;
        this.state = new NormalBudgetState();
    }

    /**
     * Observer pattern update method.
     *
     * @param id         budget id
     * @param danaKeluar outgoing money
     */
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
