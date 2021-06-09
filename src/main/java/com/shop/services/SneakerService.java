package com.shop.services;

import com.shop.models.enums.BrandEnum;
import com.shop.models.enums.SneakerConditionEnum;
import com.shop.models.service.SneakerAddServiceModel;
import com.shop.models.service.SneakerViewModel;

import java.util.List;

public interface SneakerService {

    boolean sneakerExists(String sneakerImgUrl);

    void addSneaker(SneakerAddServiceModel sneakerAddServiceModel);

    List<SneakerViewModel> getSneakers();

    List<BrandEnum> getAllBrands();

    List<SneakerConditionEnum> getAllConditions();

    SneakerViewModel getSneakerById(long sneakerId);

    void orderSneaker(long sneakerId, int quantity);

    /**
     * Seed the default sneakers in the databse
     */
    void seedSneakers();
}
