package com.shop.models.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class SneakerAddBindingModel {

    @NotBlank(message = "Please type in the sneaker brand.")
    private String brand;
    @NotBlank(message = "Please type in the sneaker condition.")
    private String condition;
    @NotBlank
    @Size(min = 3, max = 10, message = "The sneaker colour is out of bounds.")
    private String colour;
    @NotNull
    @DecimalMin(value = "1", message = "Please insert a positive value of price.")
    private BigDecimal price;
    @NotBlank(message = "Please insert an image of the sneaker.")
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
