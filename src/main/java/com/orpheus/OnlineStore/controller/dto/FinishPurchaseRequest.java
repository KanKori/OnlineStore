package com.orpheus.OnlineStore.controller.dto;

//все поля нужные для пурчес
import com.orpheus.OnlineStore.entity.ProductEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
@ToString()
public class FinishPurchaseRequest {

    @NotNull
    private List<ProductEntity> productEntityList;

    @NotEmpty
    private String userName;

    private String userSurname;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String address;

    private String comment;

}
