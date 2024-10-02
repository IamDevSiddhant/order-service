package com.example.order.service.repository;

import com.example.order.service.entity.OrderOutBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutBoxRepository extends JpaRepository<OrderOutBox,Long> {
}
