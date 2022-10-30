package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.controller.dto.FinishPurchaseRequest;
import com.orpheus.OnlineStore.entity.OrdersEntity;
import com.orpheus.OnlineStore.entity.ProductEntity;
import com.orpheus.OnlineStore.entity.PurchaseItemEntity;
import com.orpheus.OnlineStore.repository.OrdersEntityRepository;
import com.orpheus.OnlineStore.repository.PurchaseItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final ProductService productService;
    private final UserService userService;
    private final OrdersEntityRepository ordersEntityRepository;
    private final PurchaseItemRepository purchaseItemRepository;

    @Override
    public String finishPurchase(FinishPurchaseRequest request) {
        log.info("creating order from request: {}", request);
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setUsersEntity(userService.findOrCreateUser(
                request.getUserName(), request.getUserSurname(),
                request.getPhone(), request.getEmail(), request.getAddress()
        ));
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
        return ordersEntity.getId();
    }
    private Map<String, Integer> getProductIdProductCountMap(FinishPurchaseRequest request) {
        Map<String, Integer> productIdProductCount = new HashMap<>();
        request.getProductEntityList().forEach(it -> {
            if (productIdProductCount.containsKey(it.getId())) {
                Integer productCount = productIdProductCount.get(it.getId());
                productCount = productCount + 1;
                productIdProductCount.put(it.getId(), productCount);
            } else {
                productIdProductCount.put(String.valueOf(it.getId()), 1);
            }
        });
        return productIdProductCount;
    }
}
