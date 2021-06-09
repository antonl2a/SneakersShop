package com.shop.models.binding;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class SneakerAddBindingModel
{

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
    @NotNull(message = "Quantity is required")
    @DecimalMin(value = "1", message = "Provide at least 1 item")
    @DecimalMax(value = "100", message = "You cannot add more than 100 items")
    private int quantity;

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
