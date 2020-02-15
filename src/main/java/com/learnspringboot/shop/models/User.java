package com.learnspringboot.shop.models;

import lombok.Data;

import javax.persistence.*;

/**
 * @author tamvo
 * @created 15/02/2020 - 2:08 PM
 */

@Data
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String fullname;
}
