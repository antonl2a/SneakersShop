package com.shop.models.binding;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SneakerQuestionBindingModel {

    @NotBlank(message = "Please ask your question below.")
    @Size(min = 1, message = "The question must be at least 10 characters long.")
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

