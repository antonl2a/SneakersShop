package com.shop.repositories;

import com.shop.models.entities.UserRoleEntity;
import com.shop.models.enums.UserRoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRoleRepositoryTest {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Test
    void findByRoleShouldReturnCorrectRole() {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setRole(UserRoleEnum.ADMIN);
        userRoleRepository.save(userRoleEntity);
        Optional<UserRoleEntity> userRoleTest = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
        assertThat(userRoleTest.get().getRole().toString()).isEqualTo("ADMIN");
    }

    @Test
    void findByRoleShouldBeNullIfNonexistentRole() {
        Optional<UserRoleEntity> byRole = userRoleRepository.findByRole(UserRoleEnum.USER);
        assertThat(byRole.isPresent()).isFalse();
    }
}