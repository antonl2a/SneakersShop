package com.shop.models.entities;

import com.shop.models.enums.BrandEnum;
import com.shop.models.enums.SneakerConditionEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "sneakers")
public class SneakerEntity extends BaseEntity
{


    @Enumerated(EnumType.STRING)
    private BrandEnum sneakerBrand;

    @Enumerated(EnumType.STRING)
    private SneakerConditionEnum sneakerCondition;

    @Column(nullable = false)
    private String colour;

    @Column(name = "size", nullable = false)
    private int size;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String sneakerImgUrl;

    @Column(nullable = false)
    private int quantity;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BrandEnum getSneakerBrand()
    {
        return sneakerBrand;
    }

    public void setSneakerBrand(BrandEnum sneakerBrand)
    {
        this.sneakerBrand = sneakerBrand;
    }

    public SneakerConditionEnum getSneakerCondition()
    {
        return sneakerCondition;
    }

    public void setSneakerCondition(SneakerConditionEnum sneakerCondition)
    {
        this.sneakerCondition = sneakerCondition;
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
