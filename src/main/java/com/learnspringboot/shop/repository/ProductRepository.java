package com.learnspringboot.shop.repository;

import com.learnspringboot.shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tamvo
 * @created 15/02/2020 - 2:45 PM
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
