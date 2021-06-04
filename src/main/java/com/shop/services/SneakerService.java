package com.shop.services;

import com.shop.models.service.SneakerAddServiceModel;

public interface SneakerService {

    boolean sneakerExists(String sneakerImgUrl);

    void addSneaker(SneakerAddServiceModel sneakerAddServiceModel);

    void addSneakerOffer();
}
