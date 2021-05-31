package com.shop.repositories;

import com.shop.models.entities.SneakerQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SneakerQuestionRepository extends JpaRepository<SneakerQuestionEntity, Long> {
}
