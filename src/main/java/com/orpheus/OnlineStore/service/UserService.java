package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.entity.UsersEntity;

public interface UserService {
    UsersEntity findOrCreateUser(String name, String surname,
                                 String phone, String email,
                                 String address);
}
