package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.entity.UsersEntity;

public interface UserService {
    UsersEntity findOrCreateUser(String name, String surname,
                                 String phone, String email,
                                 String address);

    UsersEntity findByEmail(String email);

    UsersEntity findByEmailAndPassword(String email, String password);

    void setPassword(String userId, String password);
}
