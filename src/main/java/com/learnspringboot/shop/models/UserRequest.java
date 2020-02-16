package com.learnspringboot.shop.models;

import lombok.Data;

/**
 * @author tamvo
 * @created 16/02/2020 - 10:48 AM
 */

@Data
public class UserRequest {
    private String username;
    private String password;
}
