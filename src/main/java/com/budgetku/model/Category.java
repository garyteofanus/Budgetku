package com.budgetku.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "email")
    private User user;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

//    @ManyToMany(mappedBy = "categoryList")
//    private List<Budget> budgetList;

    public Category(String categoryName, String description, User user) {
        this.categoryName = categoryName;
        this.description = description;
        this.user = user;
    }
}
