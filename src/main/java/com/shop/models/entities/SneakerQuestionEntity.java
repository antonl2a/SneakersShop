package com.shop.models.entities;

import com.shop.models.enums.QuestionTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class SneakerQuestionEntity extends BaseEntity {

    @Column(name = "question")
    private String question;

    @Enumerated(EnumType.STRING)
    private QuestionTypeEnum typeOfQuestion;

    @Column(nullable = true)
    private String recommendations;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionTypeEnum getTypeOfQuestion() {
        return typeOfQuestion;
    }

    public void setTypeOfQuestion(QuestionTypeEnum typeOfQuestion) {
        this.typeOfQuestion = typeOfQuestion;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }
}
