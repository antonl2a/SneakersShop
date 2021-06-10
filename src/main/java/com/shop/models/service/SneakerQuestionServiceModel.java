package com.shop.models.service;

import org.springframework.web.multipart.MultipartFile;

public class SneakerQuestionServiceModel {
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

