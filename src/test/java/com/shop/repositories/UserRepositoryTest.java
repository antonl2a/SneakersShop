package com.shop.repositories;

import com.shop.models.entities.SneakerEntity;
import com.shop.models.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepositoryTest;

    @Test
    void findByUsernameShouldReturnUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("Anton");
        userEntity.setPassword("1234");

        userRepositoryTest.save(userEntity);

        Optional<UserEntity> userEntityOptional = userRepositoryTest.findByUsername("Anton");

        assertThat(userEntityOptional.get().getUsername()).isEqualTo("Anton");

    }

    @Test
    void findByUserNameShouldNotWorkIfNonexistentUser() {
        String name = "Toni";

        Optional<UserEntity> optionalUserEntity = userRepositoryTest.findByUsername(name);

        assertThat(optionalUserEntity.isPresent()).isFalse();
    }
}