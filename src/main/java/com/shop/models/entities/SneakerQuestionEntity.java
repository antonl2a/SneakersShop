package com.shop.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class SneakerQuestionEntity extends BaseEntity {

    @Column(name = "question")
    private String question;

    @Lob
    @Column(name = "issueImg")
    private byte[] issueImg;

    @Column(name = "recommendations")
    private String recommendations;

    public SneakerQuestionEntity(String question, byte[] issueImg, String recommendations) {
        this.question = question;
        this.issueImg = issueImg;
        this.recommendations = recommendations;
    }

    public byte[] getIssueImg() {
        return issueImg;
    }

    public void setIssueImg(byte[] issueImg) {
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
