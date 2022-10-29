package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.entity.ProductEntity;
import com.orpheus.OnlineStore.exeption.NotFoundException;
import com.orpheus.OnlineStore.repository.ProductEntityRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductEntityRepository productEntityRepository;
    @Override
    public List<ProductEntity> findAll() {
        return productEntityRepository.findAll();
    }

    @Override
    @SneakyThrows
    public ProductEntity findById(String id) {
        return productEntityRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product not found")
        );
    }
}
