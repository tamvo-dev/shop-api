package com.learnspringboot.shop.repository;

import com.learnspringboot.shop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tamvo
 * @created 15/02/2020 - 2:43 PM
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
