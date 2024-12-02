package com.shop.models.service;

import java.math.BigDecimal;

public class SneakerAddServiceModel
{
    private String brand;

    private String condition;

    private String colour;

    private BigDecimal price;

    private String sneakerImgUrl;

    private int quantity;

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getCondition()
    {
        return condition;
    }

    public void setCondition(String condition)
    {
        this.condition = condition;
    }

    public String getColour()
    {
        return colour;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public String getSneakerImgUrl()
    {
        return sneakerImgUrl;
    }

    public void setSneakerImgUrl(String sneakerImgUrl)
    {
        this.sneakerImgUrl = sneakerImgUrl;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
