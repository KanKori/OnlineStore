package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.controller.dto.FinishPurchaseRequest;

public interface PurchaseService {

    String finishPurchase(FinishPurchaseRequest request);
}
