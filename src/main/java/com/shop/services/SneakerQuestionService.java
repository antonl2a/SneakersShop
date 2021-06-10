package com.shop.services;

import com.shop.models.service.SneakerQuestionServiceModel;

import java.io.IOException;

public interface SneakerQuestionService {

    void addQuestion(SneakerQuestionServiceModel serviceModel) throws IOException;
}
