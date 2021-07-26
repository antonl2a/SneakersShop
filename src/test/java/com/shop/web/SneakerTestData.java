package com.shop.web;

import com.shop.models.entities.SneakerEntity;
import com.shop.models.entities.SneakerQuestionEntity;
import com.shop.models.entities.UserEntity;
import com.shop.models.enums.BrandEnum;
import com.shop.models.enums.SneakerConditionEnum;
import com.shop.repositories.LogRepository;
import com.shop.repositories.SneakerQuestionRepository;
import com.shop.repositories.SneakerRepository;
import com.shop.repositories.UserRepository;

import java.math.BigDecimal;

public class SneakerTestData {

    private long sneakerTestId;
    private UserRepository userRepository;
    private SneakerRepository sneakerRepository;
    private LogRepository logRepository;
    private SneakerQuestionRepository sneakerQuestionRepository;

    public SneakerTestData(SneakerQuestionRepository sneakerQuestionRepository, UserRepository userRepository, SneakerRepository sneakerRepository, LogRepository logRepository) {
        this.userRepository = userRepository;
        this.sneakerRepository = sneakerRepository;
        this.logRepository = logRepository;
        this.sneakerQuestionRepository = sneakerQuestionRepository;
    }

    public void init() {
        SneakerEntity sneakerEntity = new SneakerEntity();
        sneakerEntity.setColour("red");
        sneakerEntity.setSneakerBrand(BrandEnum.Adidas);
        sneakerEntity.setSneakerCondition(SneakerConditionEnum.Unworn);
        sneakerEntity.setSneakerImgUrl("https://footwearnews.com/wp-content/uploads/2019/03/m20324_01_standard-e1551720111734.jpg?w=700&h=437&crop=1");
        sneakerEntity.setPrice(BigDecimal.valueOf(25));
        sneakerEntity.setQuantity(1);
        sneakerRepository.save(sneakerEntity);

        SneakerEntity sneakerEntity1 = new SneakerEntity();
        sneakerEntity1.setColour("black");
        sneakerEntity1.setSneakerBrand(BrandEnum.Nike);
        sneakerEntity1.setSneakerCondition(SneakerConditionEnum.Wearable);
        sneakerEntity1.setSneakerImgUrl("https://cdn.runrepeat.com/i/nike/34187/nike-sneaker-air-max-98-premium-in-schwarzer-textilie-mit-mehrfarbigen-details-bunt-845b-main.jpg");
        sneakerEntity1.setPrice(BigDecimal.valueOf(33));
        sneakerEntity1.setQuantity(2);
        sneakerRepository.save(sneakerEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("ivan").setPassword("123");
        userRepository.save(userEntity);

        SneakerQuestionEntity sneakerQuestionEntity = new SneakerQuestionEntity();
        sneakerQuestionEntity.setQuestion("Available?");
        sneakerQuestionEntity.setRecommendations("could be better");
        sneakerQuestionRepository.save(sneakerQuestionEntity);

        sneakerTestId = sneakerEntity.getId();
    }

    void cleanUp() {
        logRepository.deleteAll();
        sneakerRepository.deleteAll();
        sneakerQuestionRepository.deleteAll();
    }

    public long getSneakerTestId() {
        return sneakerTestId;
    }
}
