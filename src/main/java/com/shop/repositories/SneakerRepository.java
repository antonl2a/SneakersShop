package com.shop.repositories;

import com.shop.models.entities.SneakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SneakerRepository extends JpaRepository<SneakerEntity, Long> {

    Optional<SneakerEntity> findBySneakerImgUrl(String sneakerImgUrl);
}
