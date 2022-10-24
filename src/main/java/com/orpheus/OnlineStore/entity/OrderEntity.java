package com.orpheus.OnlineStore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Order")
@Entity
@Data
public class OrderEntity extends BaseEntity {

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "purchase_item_id")
    private PurchaseItemEntity purchaseItemEntity;
}
