package com.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class SneakersShopApplicationTests {

    Calculator calculator = new Calculator();

    @Test
    void itShouldAddNumbers() {
        int n1 = 10;
        int n2 = 20;

        int result = calculator.add(n1, n2);

        assertThat(result).isEqualTo(32);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }

}
