package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.entity.ProductEntity;
import com.orpheus.OnlineStore.exeption.NotFoundException;
import com.orpheus.OnlineStore.repository.ProductEntityRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class for performing operations on products
 * @author Anastasiia Voshchenko
 * @since 2022
 * @version %I%, %G%
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductEntityRepository productEntityRepository;

    /**
     * Method that find all products from repo
     * @return all products from repo
     */
    @Override
    public List<ProductEntity> findAll() {
        return productEntityRepository.findAll();
    }

    /**
     * Method that find products by id
     * @param id input id
     * @return desired product
     */
    @Override
    @SneakyThrows
    public ProductEntity findById(String id) {
        return productEntityRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product not found")
        );
    }
}
