package com.example.projectdemobackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    @Column(columnDefinition = "TEXT")
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
