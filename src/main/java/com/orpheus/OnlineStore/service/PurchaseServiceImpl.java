package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.controller.dto.FinishPurchaseRequest;
import com.orpheus.OnlineStore.entity.OrdersEntity;
import com.orpheus.OnlineStore.entity.ProductEntity;
import com.orpheus.OnlineStore.entity.PurchaseItemEntity;
import com.orpheus.OnlineStore.entity.UsersEntity;
import com.orpheus.OnlineStore.repository.OrdersEntityRepository;
import com.orpheus.OnlineStore.repository.PurchaseItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for performing operations on finish purchase
 * @author Anastasiia Voshchenko
 * @since 2022
 * @version %I%, %G%
 */
@Service
@AllArgsConstructor
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    private final ProductService productService;
    private final UserService userService;
    private final OrdersEntityRepository ordersEntityRepository;
    private final PurchaseItemRepository purchaseItemRepository;

    /**
     * Method for create the order from request
     * @param request input request
     * @return string that contains finished purchase
     */
    @Override
    public String finishPurchase(FinishPurchaseRequest request) {
        log.info("creating order from request: {}", request);
        OrdersEntity ordersEntity = new OrdersEntity();
        UsersEntity userEntity = userService.findOrCreateUser(request.getUserName(), request.getUserSurname(),
                request.getPhone(), request.getEmail(), request.getAddress());
        ordersEntity.setUsersEntity(userEntity);
        ordersEntity.setComment(request.getComment());
        ordersEntity = ordersEntityRepository.save(ordersEntity);
        Map<String, Integer> productIdProductCount =  getProductIdProductCountMap(request);

        for (Map.Entry<String, Integer> entry : productIdProductCount.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            ProductEntity productEntity = productService.findById(k);
            PurchaseItemEntity p = new PurchaseItemEntity();
            p.setProductEntity(productEntity);
            p.setCount(v);
            p.setOrdersEntity(ordersEntity);
            purchaseItemRepository.save(p);
        }

        if (request.getPassword() != null && request.getPassword().length() > 1) {
            userService.setPassword(userEntity.getId(), request.getPassword());
        }

        return ordersEntity.getId();
    }

    /**
     * Method for get Map with key = productId and value = productCount
     * @param request input request
     * @return Map<String, Integer> with key = productId and value = productCount
     */
    private Map<String, Integer> getProductIdProductCountMap(FinishPurchaseRequest request) {
        Map<String, Integer> productIdProductCount = new HashMap<>();
        final int ONE_JOKE = 1;
        request.getProductEntityList().forEach(it -> {
            if (productIdProductCount.containsKey(it.getId())) {
                Integer productCount = productIdProductCount.get(it.getId());
                productCount = productCount + ONE_JOKE;
                productIdProductCount.put(it.getId(), productCount);
            } else {
                productIdProductCount.put(String.valueOf(it.getId()), ONE_JOKE);
            }
        });
        return productIdProductCount;
    }
}
