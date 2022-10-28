package com.orpheus.OnlineStore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "orders")
@Entity
@Data
public class OrdersEntity extends BaseEntity {

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UsersEntity usersEntity;

}
