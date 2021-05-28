package com.budgetku.model;

import com.budgetku.budgetstate.BudgetState;
import com.budgetku.budgetstate.NormalBudgetState;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    public void changeState(BudgetState newState) {
        this.state = newState;
    }
}
