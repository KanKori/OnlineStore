package com.orpheus.OnlineStore.service;

import com.orpheus.OnlineStore.entity.UsersEntity;
import com.orpheus.OnlineStore.entity.UsersStatus;
import com.orpheus.OnlineStore.repository.UsersEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.orpheus.OnlineStore.entity.UserRole.CUSTOMER;
import static com.orpheus.OnlineStore.entity.UsersStatus.ACTIVE;
import static com.orpheus.OnlineStore.entity.UsersStatus.DISABLED;
import static java.util.Objects.nonNull;

/**
 * Class for performing operations on users entity
 * @author Anastasiia Voshchenko
 * @since 2022
 * @version %I%, %G%
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersEntityRepository usersEntityRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * Method for find or create (if not exist) user
     * @param name User name
     * @param surname User surname
     * @param phone User phone
     * @param email User email
     * @param address User address
     * @return saved UsersEntity
     */
    @Override
    public UsersEntity findOrCreateUser(String name, String surname, String phone, String email, String address) {
        UsersEntity usersEntity = usersEntityRepository.findByEmail(email);
        if (nonNull(usersEntity)) {
            return usersEntity;
        }
        usersEntity = new UsersEntity();
        usersEntity.setRole(CUSTOMER);
        usersEntity.setStatus(DISABLED);
        usersEntity.setName(name);
        usersEntity.setSurname(surname);
        usersEntity.setAddress(address);
        usersEntity.setPhone(phone);
        usersEntity.setEmail(email);
        return usersEntityRepository.save(usersEntity);
    }

    @Override
    public UsersEntity findByEmail(String email) {
        return usersEntityRepository.findByEmail(email);
    }

    @Override
    public UsersEntity findByEmailAndPassword(String email, String password) {
        UsersEntity userEntity = findByEmail(email);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public void setPassword(String userId, String password) {
        UsersEntity userEntity = usersEntityRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found by id: " + userId));
        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity.setStatus(ACTIVE);
        usersEntityRepository.save(userEntity);
    }
}
