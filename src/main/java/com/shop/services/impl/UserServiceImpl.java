package com.shop.services.impl;

import com.shop.models.entities.UserEntity;
import com.shop.models.entities.UserRoleEntity;
import com.shop.models.enums.UserRoleEnum;
import com.shop.models.service.UserRegisterServiceModel;
import com.shop.repositories.UserRepository;
import com.shop.repositories.UserRoleRepository;
import com.shop.services.SneakersShopUserService;
import com.shop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    private final SneakersShopUserService sneakersShopUserService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository, SneakersShopUserService sneakersShopUserService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.sneakersShopUserService = sneakersShopUserService;
    }

    @Override
    public boolean usernameExists(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        return user.isPresent();
    }

    @Override
    public void loginAndRegisterUser(UserRegisterServiceModel userRegisterServiceModel) {
        UserEntity newUser = modelMapper.map(userRegisterServiceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(userRegisterServiceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository
                .findByRole(UserRoleEnum.USER)
                .orElseThrow(() -> new IllegalStateException("User role not found. Please seed the roles"));

        newUser.addRole(userRole);

        newUser = userRepository.save(newUser);

        UserDetails principal = sneakersShopUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
               principal,
               newUser.getPassword(),
               principal.getAuthorities()

       );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public void seedUsers() {
        if (userRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRoleEnum.USER);
            userRoleRepository.saveAll(List.of(adminRole, userRole));
            UserEntity admin = new UserEntity().setPassword(passwordEncoder.encode("topsecret")).setUsername("admin").setPhone("0879843832");
            UserEntity user = new UserEntity().setPassword(passwordEncoder.encode("topsecret")).setUsername("user").setPhone("0879943832");
            admin.setRoles(List.of(adminRole, userRole));
            user.setRoles(List.of(userRole));
            userRepository.saveAll(List.of(admin, user));
        }
    }

    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserEntity findByName(String username) {
       return userRepository.findByUsername(username).orElseThrow(IllegalArgumentException::new);
    }
}
