package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.entity.UsersEntity;
import com.orpheus.OnlineStore.repository.UsersEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.orpheus.OnlineStore.entity.UserRole.CUSTOMER;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersEntityRepository usersEntityRepository;


    @Override
    public UsersEntity findOrCreateUser(String name, String surname, String phone, String email, String address) {
        UsersEntity usersEntity = usersEntityRepository.findByEmail(email);
        if (nonNull(usersEntity)) {
            return usersEntity;
        }
        usersEntity = new UsersEntity();
        usersEntity.setRole(CUSTOMER.name());
        usersEntity.setName(name);
        usersEntity.setSurname(surname);
        usersEntity.setAddress(address);
        usersEntity.setPhone(phone);
        usersEntity.setEmail(email);
        return usersEntityRepository.save(usersEntity);
    }
}
