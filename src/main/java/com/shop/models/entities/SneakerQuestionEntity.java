package com.shop.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class SneakerQuestionEntity extends BaseEntity {

    @Column(name = "question")
    private String question;
    @Column(name = "username")
    private String username;
    public SneakerQuestionEntity() {
    }

    public SneakerQuestionEntity(String question, String username) {
        this.question = question;
        this.username = username;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
