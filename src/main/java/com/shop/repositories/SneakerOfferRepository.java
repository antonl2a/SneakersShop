package com.shop.repositories;

import com.shop.models.entities.SneakerOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SneakerOfferRepository extends JpaRepository<SneakerOfferEntity, Long> {
}
