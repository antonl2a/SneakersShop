package com.shop.services.impl;

import com.cloudinary.Cloudinary;
import com.shop.models.entities.SneakerEntity;
import com.shop.models.enums.BrandEnum;
import com.shop.models.enums.SneakerConditionEnum;
import com.shop.models.service.SneakerAddServiceModel;
import com.shop.models.service.SneakerViewModel;
import com.shop.repositories.SneakerRepository;
import com.shop.services.CloudinaryService;
import com.shop.services.SneakerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SneakerServiceImpl implements SneakerService
{

    private final SneakerRepository sneakerRepository;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;

    public SneakerServiceImpl(SneakerRepository sneakerRepository, ModelMapper modelMapper, Cloudinary cloudinary, CloudinaryService cloudinaryService)
    {
        this.sneakerRepository = sneakerRepository;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public boolean sneakerExists(String sneakerImgUrl)
    {
        return sneakerRepository.findBySneakerImgUrl(sneakerImgUrl).isPresent();
    }

    @Override
    public void addSneaker(SneakerAddServiceModel sneakerAddServiceModel)
    {
        SneakerEntity newSneaker = modelMapper.map(sneakerAddServiceModel, SneakerEntity.class);

        sneakerRepository.save(newSneaker);
    }

    @Override
    public List<SneakerViewModel> getSneakers()
    {
        return sneakerRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, SneakerViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BrandEnum> getAllBrands()
    {
        return Arrays.stream(BrandEnum.values()).collect(Collectors.toList());
    }

    @Override
    public List<SneakerConditionEnum> getAllConditions()
    {
        return Arrays.stream(SneakerConditionEnum.values()).collect(Collectors.toList());
    }

    @Override
    public SneakerViewModel getSneakerById(long sneakerId)
    {
        SneakerEntity entity = sneakerRepository.findById(sneakerId).orElseThrow();

        return modelMapper.map(entity, SneakerViewModel.class);
    }

    @Override
    public void orderSneaker(long sneakerId, int quantity)
    {
        SneakerEntity entity = sneakerRepository.findById(sneakerId).orElseThrow();

        if (entity.getQuantity() <= quantity) {
            sneakerRepository.delete(entity);
        } else {
            entity.setQuantity(entity.getQuantity() - quantity);
            sneakerRepository.save(entity);
        }
    }

    @Override
    public void seedSneakers()
    {
        BrandEnum[] allBrands = BrandEnum.values();
        SneakerConditionEnum[] allConditions = SneakerConditionEnum.values();
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Cyan", "Black", "White"};
        String[] sneakerUrls = {"https://images.unsplash.com/photo-1597248881519-db089d3744a5?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c25lYWtlcnN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1552346154-21d32810aba3?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8c25lYWtlcnN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1595950653106-6c9ebd614d3a?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c25lYWtlcnN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1579338559194-a162d19bf842?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8c25lYWtlcnN8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1607522370275-f14206abe5d3?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fHNuZWFrZXJzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1603036050141-c61fde866f5c?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTV8fHNuZWFrZXJzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                "https://images.unsplash.com/photo-1552346053-c33aa8b3d665?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fHNuZWFrZXJzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
        };

        final int RANDOM_SNEAKER_COUNT = 30;

        for (int i = 0; i < RANDOM_SNEAKER_COUNT; i++) {
            SneakerEntity sneaker = new SneakerEntity();
            sneaker.setColour(randomInArray(colors));
            sneaker.setSneakerBrand(randomInArray(allBrands));
            sneaker.setSneakerCondition(randomInArray(allConditions));
            sneaker.setSneakerImgUrl(randomInArray(sneakerUrls));
            sneaker.setPrice(BigDecimal.valueOf(randomNumberInRange(1, 300)));
            sneaker.setQuantity(randomNumberInRange(1, 100));
            sneakerRepository.save(sneaker);
        }

    }

    @Override
    public SneakerEntity findEntityById(Long sneakerId) {

        return sneakerRepository.findById(sneakerId).orElseThrow(IllegalArgumentException::new);
    }


    private <T> T randomInArray(T[] arr)
    {
        final int index = randomNumberInRange(0, arr.length);

        return arr[index];
    }

    private int randomNumberInRange(int min, int max)
    {
        return ThreadLocalRandom.current().nextInt(min, max);
    }


}
