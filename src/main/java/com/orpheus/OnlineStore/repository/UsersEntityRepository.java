package com.orpheus.OnlineStore.repository;

import com.orpheus.OnlineStore.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersEntityRepository extends JpaRepository<UsersEntity, String> {

    UsersEntity findByEmail(String email);
}
