package com.shop.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class LogEntity extends BaseEntity {

    @ManyToOne
    private UserEntity userEntity;
    @ManyToOne
    private SneakerEntity sneakerEntity;
    @Column(name = "count", nullable = false)
    private int orderCount;
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    public LogEntity() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public SneakerEntity getSneakerEntity() {
        return sneakerEntity;
    }

    public void setSneakerEntity(SneakerEntity sneakerEntity) {
        this.sneakerEntity = sneakerEntity;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}
