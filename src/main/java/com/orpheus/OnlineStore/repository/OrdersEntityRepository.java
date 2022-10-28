package com.orpheus.OnlineStore.repository;

import com.orpheus.OnlineStore.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersEntityRepository extends JpaRepository<OrdersEntity, String> {
}
