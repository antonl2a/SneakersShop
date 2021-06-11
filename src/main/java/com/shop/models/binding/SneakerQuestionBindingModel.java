package com.shop.models.binding;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SneakerQuestionBindingModel {

    @NotBlank(message = "Please ask your question below.")
    @Size(min = 10, message = "The question must be at least 10 characters long.")
    private String question;

    private String recommendations;

    private MultipartFile issueImg;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public MultipartFile getIssueImg() {
        return issueImg;
    }

    public void setIssueImg(MultipartFile issueImg) {
        this.issueImg = issueImg;
    }
}

