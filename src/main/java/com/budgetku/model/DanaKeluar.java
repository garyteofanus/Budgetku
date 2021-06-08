package com.budgetku.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "deskripsi")
    private String deskripsi;

    @Transient
    private Budget budget;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private User user;

    public DanaKeluar(Integer nominal, Budget budget, String deskripsi, User user) {
        super();
        this.nominal = nominal;
        this.budget = budget;
        this.deskripsi = deskripsi;
        this.user = user;
    }

//    public DanaKeluar(Integer nominal, String tanggal, String deskripsi) throws ParseException {
//        this(
//                nominal,
//                new SimpleDateFormat("yyyy-MM-dd").parse(tanggal),
//                deskripsi,
//                null
//        );
//    }
}
