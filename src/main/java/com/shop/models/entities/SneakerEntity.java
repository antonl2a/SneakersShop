package com.shop.models.entities;

import com.shop.models.enums.BrandEnum;
import com.shop.models.enums.InStockEnum;
import com.shop.models.enums.SneakerConditionEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "sneakers")
public class SneakerEntity extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private BrandEnum sneakerBrand;

    @Enumerated(EnumType.STRING)
    private SneakerConditionEnum sneakerCondition;

    @Column(nullable = false)
    private String colour;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String sneakerImgUrl;

    @Enumerated(EnumType.STRING)
    private InStockEnum sneakerInStock;

    public BrandEnum getSneakerBrand() {
        return sneakerBrand;
    }

    public void setSneakerBrand(BrandEnum sneakerBrand) {
        this.sneakerBrand = sneakerBrand;
    }

    public SneakerConditionEnum getSneakerCondition() {
        return sneakerCondition;
    }

    public void setSneakerCondition(SneakerConditionEnum sneakerCondition) {
        this.sneakerCondition = sneakerCondition;
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

    public InStockEnum getSneakerInStock() {
        return sneakerInStock;
    }

    public void setSneakerInStock(InStockEnum sneakerInStock) {
        this.sneakerInStock = sneakerInStock;
    }
}
