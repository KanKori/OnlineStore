package com.orpheus.OnlineStore.controller;

import com.orpheus.OnlineStore.entity.ProductEntity;
import com.orpheus.OnlineStore.service.ProductService;
import com.orpheus.OnlineStore.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class for control product
 * @author Anastasiia Voshchenko
 * @since 2022
 * @version %I%, %G%
 */
@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    /**
     * Method for get all products from request
     * @return List of all products
     */
    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        log.info("handling get all products request");
        return productService.findAll();
    }

    /**
     * Method for get product by id from request
     * @return desired product
     */
    @GetMapping("/products/{id}")
    public ProductEntity findById(@PathVariable String id) {
        log.info("handling get product by id: {}", id);
        return productService.findById(id);
    }
}
