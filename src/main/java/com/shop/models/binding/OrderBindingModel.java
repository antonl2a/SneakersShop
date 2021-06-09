package com.shop.models.binding;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderBindingModel
{
    @NotNull
    @Min(0)
    private int quantity;

    private long sneakerId;

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public long getSneakerId()
    {
        return sneakerId;
    }

    public void setSneakerId(long sneakerId)
    {
        this.sneakerId = sneakerId;
    }
}
