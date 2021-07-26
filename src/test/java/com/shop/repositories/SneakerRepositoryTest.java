package com.shop.repositories;

import com.shop.models.entities.SneakerEntity;
import com.shop.models.enums.BrandEnum;
import com.shop.models.enums.SneakerConditionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class SneakerRepositoryTest {


    @Autowired
    private SneakerRepository sneakerRepositoryTest;

    @Test
    void itShouldFindBySneakerImgUrl() {
        SneakerEntity sneakerEntity = new SneakerEntity();
        sneakerEntity.setSneakerImgUrl("https://martinvalen.com/14099-large_default/men-s-stitch-zipper-sneakers-shoes-white.jpg");
        sneakerEntity.setSneakerBrand(BrandEnum.Adidas);
        sneakerEntity.setSneakerCondition(SneakerConditionEnum.Unworn);
        sneakerEntity.setQuantity(1);
        sneakerEntity.setPrice(BigDecimal.valueOf(200));
        sneakerEntity.setColour("Red");
        String imgUrl = "https://martinvalen.com/14099-large_default/men-s-stitch-zipper-sneakers-shoes-white.jpg";

        sneakerRepositoryTest.save(sneakerEntity);

        Optional<SneakerEntity> optionalSneakerEntity = sneakerRepositoryTest.findBySneakerImgUrl(imgUrl);

        assertThat(optionalSneakerEntity.get().getSneakerImgUrl()).isEqualTo(imgUrl);


    }

    @Test
    void itShouldNotFindBySneakerImgUrlIfNonExistestEntity() {
        String imgUrl = "https://martinvalen.com/14099-large_default/men-s-stitch-zipper-sneakers-shoes-white.jpg";

        Optional<SneakerEntity> optionalSneakerEntity = sneakerRepositoryTest.findBySneakerImgUrl(imgUrl);

        assertThat(optionalSneakerEntity.isPresent()).isFalse();


    }
}