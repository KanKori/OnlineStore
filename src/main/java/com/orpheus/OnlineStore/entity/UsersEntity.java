package com.orpheus.OnlineStore.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Class for describing users entity
 * @author Anastasiia Voshchenko
 * @since 2022
 * @version %I%, %G%
 */
@Table(name = "users", schema = "public")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
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
    @Enumerated
    private UserRole role;

    @Column
    private String address;

    @Column
    @Enumerated
    private UsersStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsersEntity that = (UsersEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
