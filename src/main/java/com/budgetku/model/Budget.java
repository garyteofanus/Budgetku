package com.budgetku.model;

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
            name = "budget_category",
            joinColumns = @JoinColumn(name = "budget_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private List<Kategori> categoryList;

    @ManyToOne
    @JoinColumn(name = "user_budget")
    private User user;

    public Budget(Long nominal, Date tanggal, String deskripsi, User user) {
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.user = user;
    }

//    public Budget(Long nominal, String tanggal, String deskripsi, User user) {
//        this(
//                nominal,
//                Date.parse(tanggal, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
//                deskripsi,
//                user
//        );
//    }
}
