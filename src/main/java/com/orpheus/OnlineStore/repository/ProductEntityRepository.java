package com.orpheus.OnlineStore.repository;

import com.orpheus.OnlineStore.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, String> {
}
