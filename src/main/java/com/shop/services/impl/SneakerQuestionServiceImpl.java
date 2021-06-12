package com.shop.services.impl;

import com.shop.models.entities.SneakerQuestionEntity;
import com.shop.models.service.SneakerQuestionServiceModel;
import com.shop.repositories.SneakerQuestionRepository;
import com.shop.services.CloudinaryService;
import com.shop.services.SneakerQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SneakerQuestionServiceImpl implements SneakerQuestionService {

    private final SneakerQuestionRepository sneakerQuestionRepository;
    private final CloudinaryService cloudinaryService;

    public SneakerQuestionServiceImpl(SneakerQuestionRepository sneakerQuestionRepository, CloudinaryService cloudinaryService) {
        this.sneakerQuestionRepository = sneakerQuestionRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public void addQuestion(SneakerQuestionServiceModel serviceModel) throws IOException {
        byte[] data = serviceModel.getIssueImg().getBytes();

        try {
            SneakerQuestionEntity entity = new SneakerQuestionEntity(serviceModel.getQuestion(), data, serviceModel.getRecommendations());
            sneakerQuestionRepository.save(entity);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
