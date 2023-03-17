package com.brvsk.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "description",
            nullable = false
    )
    private String description;

    @Column(
            name = "price",
            nullable = false
    )
    private Double price;

    @Column(
            name = "create_time",
            nullable = false
    )
    private LocalDateTime createTime;

//    @OneToMany(
//            fetch = FetchType.LAZY,
//            mappedBy = "product"
//    )
//    private List<Purchase> purchaseList;
}
