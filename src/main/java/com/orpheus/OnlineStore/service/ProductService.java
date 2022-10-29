package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> findAll();
    ProductEntity findById(String id);
}
