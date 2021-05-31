package com.shop.services;

import com.shop.models.entities.UserEntity;
import com.shop.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SneakersShopUserService implements UserDetailsService {
    private final UserRepository userRepository;

    public SneakersShopUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.shop.models.entities.UserEntity userEntity = userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User with name" + username + "not found."));

        return mapToUserDetails(userEntity);
    }

    private UserDetails mapToUserDetails(UserEntity userEntity) {
        List<GrantedAuthority> authorities = userEntity
                .getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                .collect(Collectors.toList());
        return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
    }
}
