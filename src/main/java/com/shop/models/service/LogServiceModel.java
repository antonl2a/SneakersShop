package com.shop.models.service;

import com.shop.models.entities.SneakerEntity;
import com.shop.models.entities.UserEntity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class LogServiceModel {

    private Long id;
    private String userEntity;
    private String sneakerEntity;
    private int orderCount;
    private LocalDateTime dateTime;
    private int size;
    private Long sneakerId;
    private String sneakerImgUrl;

    public LogServiceModel() {
    }

    public String getSneakerImgUrl() {
        return sneakerImgUrl;
    }

    public void setSneakerImgUrl(String sneakerImgUrl) {
        this.sneakerImgUrl = sneakerImgUrl;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Long getSneakerId() {
        return sneakerId;
    }

    public void setSneakerId(Long sneakerId) {
        this.sneakerId = sneakerId;
    }

    public String getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(String userEntity) {
        this.userEntity = userEntity;
    }

    public String getSneakerEntity() {
        return sneakerEntity;
    }

    public void setSneakerEntity(String sneakerEntity) {
        this.sneakerEntity = sneakerEntity;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
