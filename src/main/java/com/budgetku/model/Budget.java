package com.budgetku.model;

import com.budgetku.core.state.BudgetState;
import com.budgetku.core.state.NormalBudgetState;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "budget")
@Data
@NoArgsConstructor
@ToString
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kategori_id")
    @JsonIgnore
    private Kategori kategori;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonIgnore
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
    public Budget(Long nominal, Date tanggal, String deskripsi, Kategori kategori, User user) {
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
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
