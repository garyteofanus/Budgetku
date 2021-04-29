package com.budgetku.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "budget")
@Data
@NoArgsConstructor
public class Budget {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="email")
    private User user;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "budget")
    private int budget;

    @Column(name = "sisa_budget")
    private int sisaBudget;

    public Budget(String category, String description, User user) {
        this.category = category;
        this.description = description;
        this.user = user;
    }
}
