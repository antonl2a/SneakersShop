package com.shop.models.service;

import com.shop.models.enums.BrandEnum;
import com.shop.models.enums.SneakerConditionEnum;

import java.math.BigDecimal;

public class SneakerViewModel
{
    private long id;

    private BrandEnum sneakerBrand;

    private SneakerConditionEnum sneakerCondition;

    private String colour;

    private int size;

    private BigDecimal price;

    private String sneakerImgUrl;

    private int quantity;



    public SneakerViewModel()
    {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public BrandEnum getSneakerBrand()
    {
        return sneakerBrand;
    }

    public SneakerConditionEnum getSneakerCondition()
    {
        return sneakerCondition;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getColour()
    {
        return colour;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String getSneakerImgUrl()
    {
        return sneakerImgUrl;
    }

    public void setSneakerBrand(BrandEnum sneakerBrand)
    {
        this.sneakerBrand = sneakerBrand;
    }

    public void setSneakerCondition(SneakerConditionEnum sneakerCondition)
    {
        this.sneakerCondition = sneakerCondition;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public void setSneakerImgUrl(String sneakerImgUrl)
    {
        this.sneakerImgUrl = sneakerImgUrl;
    }
}
