package com.brvsk.shop.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "user_id",
            nullable = false
    )
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false)
    private User user;

    @Column(
            name = "product_id",
            nullable = false
    )
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false)
    private Product product;

    @Column(
            name = "price",
            nullable = false
    )
    private Double price;

    @Column(
            name = "purchase_time",
            nullable = false
    )
    private LocalDateTime purchaseTime;
}

