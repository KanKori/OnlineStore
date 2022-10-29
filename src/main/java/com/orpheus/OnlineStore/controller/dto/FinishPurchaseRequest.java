package com.orpheus.OnlineStore.controller.dto;

//все поля нужные для пурчес
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
public class FinishPurchaseRequest {

    @NotNull
    private List<String> productIds;

    @NotEmpty
    private String usersName;

    private String usersSurname;

    @NotEmpty
    private String usersEmail;

    @NotEmpty
    private String usersPhone;

    @NotEmpty
    private String usersAddress;

    private String comment;

}
