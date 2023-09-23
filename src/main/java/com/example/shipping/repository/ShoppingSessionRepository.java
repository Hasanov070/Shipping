package com.example.shipping.repository;

import com.example.shipping.model.CartItem;
import com.example.shipping.model.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingSessionRepository extends JpaRepository<ShoppingSession, Long> {
    ShoppingSession getShoppingSessionById(Long id);
}
