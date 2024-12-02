package com.shop.services.impl;

import com.shop.models.entities.SneakerQuestionEntity;
import com.shop.models.service.SneakerQuestionServiceModel;
import com.shop.repositories.SneakerQuestionRepository;
import com.shop.services.SneakerQuestionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SneakerQuestionServiceImpl implements SneakerQuestionService {

    private final SneakerQuestionRepository sneakerQuestionRepository;

    public SneakerQuestionServiceImpl(SneakerQuestionRepository sneakerQuestionRepository) {
        this.sneakerQuestionRepository = sneakerQuestionRepository;
    }

    @Override
    public void addQuestion(SneakerQuestionServiceModel serviceModel) throws IOException {
        try {
            Authentication authentication = SecurityContextHolder.
                    getContext().getAuthentication();
            String username = authentication.getName();
            SneakerQuestionEntity entity = new SneakerQuestionEntity(serviceModel.getQuestion(), username);
            sneakerQuestionRepository.save(entity);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
