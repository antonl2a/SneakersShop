package com.shop.services.impl;

import com.shop.models.entities.SneakerEntity;
import com.shop.models.service.SneakerAddServiceModel;
import com.shop.repositories.SneakerRepository;
import com.shop.services.SneakerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SneakerServiceImpl implements SneakerService {

    private final SneakerRepository sneakerRepository;
    private final ModelMapper modelMapper;

    public SneakerServiceImpl(SneakerRepository sneakerRepository, ModelMapper modelMapper) {
        this.sneakerRepository = sneakerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean sneakerExists(String sneakerImgUrl) {
        return sneakerRepository.findBySneakerImgUrl(sneakerImgUrl).isPresent();
    }

    @Override
    public void addSneaker(SneakerAddServiceModel sneakerAddServiceModel) {
        SneakerEntity newSneaker = modelMapper.map(sneakerAddServiceModel, SneakerEntity.class);

        sneakerRepository.save(newSneaker);
    }
}
