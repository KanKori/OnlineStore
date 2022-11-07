package com.orpheus.OnlineStore.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class for describing finish purchase response
 * @author Anastasiia Voshchenko
 * @since 2022
 * @version %I%, %G%
 */
@Data
@AllArgsConstructor
public class FinishPurchaseResponse {
    private String orderId;
}
