package com.orpheus.OnlineStore.controller;

import com.orpheus.OnlineStore.controller.dto.FinishPurchaseRequest;
import com.orpheus.OnlineStore.controller.dto.FinishPurchaseResponse;
import com.orpheus.OnlineStore.service.PurchaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Class for control finish purchase from request
 * @author Anastasiia Voshchenko
 * @since 2022
 * @version %I%, %G%
 */
@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/finishPurchase")
    public ResponseEntity<FinishPurchaseResponse> finishPurchase(@Valid  FinishPurchaseRequest request) {
        log.info("handling finish purchase request: {}", request);
        String orderId = purchaseService.finishPurchase(request);
        return ResponseEntity.ok(new FinishPurchaseResponse(orderId));
    }

}
