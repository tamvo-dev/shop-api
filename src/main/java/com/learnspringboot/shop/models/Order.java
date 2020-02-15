package com.learnspringboot.shop.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * @author tamvo
 * @created 15/02/2020 - 2:27 PM
 */

@Data
@Entity(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int count;
    private int price;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
