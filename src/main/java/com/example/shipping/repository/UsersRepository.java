package com.example.shipping.repository;

import com.example.shipping.model.CartItem;
import com.example.shipping.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users getUsersById(Long id);
}
