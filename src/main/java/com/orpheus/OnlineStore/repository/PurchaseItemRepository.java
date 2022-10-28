package com.orpheus.OnlineStore.repository;

import com.orpheus.OnlineStore.entity.PurchaseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItemEntity, String> {
}
