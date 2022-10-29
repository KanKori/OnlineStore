package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.controller.dto.FinishPurchaseRequest;
import com.orpheus.OnlineStore.entity.OrdersEntity;
import com.orpheus.OnlineStore.entity.ProductEntity;
import com.orpheus.OnlineStore.entity.PurchaseItemEntity;
import com.orpheus.OnlineStore.repository.OrdersEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final ProductService productService;
    private final UserService userService;
    private final OrdersEntityRepository ordersEntityRepository;

    @Override
    public String finishPurchase(FinishPurchaseRequest request) {
        log.info("creating order from request: {}", request);
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setUsersEntity(userService.findOrCreateUser(request.getUsersName(), request.getUsersSurname(),
                request.getUsersPhone(), request.getUsersEmail(), request.getUsersAddress()));
        ordersEntity.setComment(request.getComment());
        ordersEntity = ordersEntityRepository.save(ordersEntity);

        for (Map.Entry<String, Integer> entry : request.getProductIdProductCount().entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            ProductEntity productEntity = productService.findById(k);
            PurchaseItemEntity p = new PurchaseItemEntity();
            p.setProductEntity(productEntity);
            p.setCount(v);
            p.setOrdersEntity(ordersEntity);
        }
        return ordersEntity.getId();
    }
}
