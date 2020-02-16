package com.learnspringboot.shop.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author tamvo
 * @created 16/02/2020 - 11:04 AM
 */

@Data
@RequiredArgsConstructor
public class UserResponse {
    private final String token;
}
