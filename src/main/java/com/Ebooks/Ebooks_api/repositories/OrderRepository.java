package com.Ebooks.Ebooks_api.repositories;

import com.Ebooks.Ebooks_api.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByPaymentIntentId(String payment);
}
