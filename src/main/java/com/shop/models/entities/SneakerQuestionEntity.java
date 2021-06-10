package com.shop.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class SneakerQuestionEntity extends BaseEntity {

    @Column(name = "question")
    private String question;

    @Column(name = "image", columnDefinition = "TEXT")
    private String issueImg;

    @Column(name = "recommendations")
    private String recommendations;

    public String getIssueImg() {
        return issueImg;
    }

    public void setIssueImg(String issueImg) {
        this.issueImg = issueImg;
    }

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
}
