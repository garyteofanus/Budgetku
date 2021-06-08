package com.budgetku.model;

import com.budgetku.core.state.BudgetState;
import com.budgetku.core.state.NormalBudgetState;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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

    @Column(name = "bulan_berakhir")
    private String bulanBerakhir;

    @Column(name = "tahun_berakhir")
    private String tahunBerakhir;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kategori_id")
    @JsonManagedReference
    // @JsonBackReference
    private Kategori kategori;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private User user;

    // @JsonInclude()
    @Transient
    // @JsonProperty
    // @Basic(optional=false)
    private BudgetState state;

    /**
     * Constructor for Budget.
     *
     * @param nominal       nominal of the budget
     * @param bulanBerakhir expiration month for the budget
     * @param tahunBerakhir expiration year for the budget
     * @param deskripsi     description for the budget
     * @param user          user that perform create the budget
     */
    public Budget(Long nominal,
                  String bulanBerakhir,
                  String tahunBerakhir,
                  String deskripsi,
                  Kategori kategori,
                  User user) {
        this.nominal = nominal;
        this.bulanBerakhir = bulanBerakhir;
        this.tahunBerakhir = tahunBerakhir;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.user = user;
        this.setState(new NormalBudgetState());
        System.out.println(this.getState());
    }

    // public void changeState(BudgetState newState) {
    //     System.out.println("Changing");
    //     System.out.println(this.getState());
    //     this.state = newState;
    //     System.out.println(this.getState());
    // }
}
