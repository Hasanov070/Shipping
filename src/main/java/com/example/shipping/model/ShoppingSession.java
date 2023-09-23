package com.example.shipping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shoppingsession")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total")
    private String total;
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "modifiedAt")
    private String modifiedAt;

    @OneToMany(mappedBy = "shoppingSession", orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;

}
