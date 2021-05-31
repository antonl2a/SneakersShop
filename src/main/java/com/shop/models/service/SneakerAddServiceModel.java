package com.shop.models.service;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class SneakerAddServiceModel {
    private String brand;
    private String condition;
    private String colour;
    private BigDecimal price;
    private String sneakerImgUrl;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSneakerImgUrl() {
        return sneakerImgUrl;
    }

    public void setSneakerImgUrl(String sneakerImgUrl) {
        this.sneakerImgUrl = sneakerImgUrl;
    }
}
