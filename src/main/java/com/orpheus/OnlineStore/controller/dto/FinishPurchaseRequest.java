package com.orpheus.OnlineStore.controller.dto;

import com.orpheus.OnlineStore.entity.ProductEntity;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Class for describing finish purchase request
 * @author Anastasiia Voshchenko
 * @since 2022
 * @version %I%, %G%
 */
@Data
@ToString(exclude = "password")
public class FinishPurchaseRequest {

    @NotNull
    private List<ProductEntity> productEntityList;

    @NotEmpty
    private String userName;

    private String userSurname;

    private String password;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String address;

    private String comment;

}
