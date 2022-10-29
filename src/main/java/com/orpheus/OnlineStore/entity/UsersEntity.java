package com.orpheus.OnlineStore.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "users", schema = "public")
@Entity
@Data
@ToString
public class UsersEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String password;

    @Column
    private String role;

    @Column
    private String address;

    @Column
    private String status;
}
