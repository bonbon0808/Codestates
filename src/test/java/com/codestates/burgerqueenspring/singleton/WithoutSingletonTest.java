package com.codestates.burgerqueenspring.singleton;

import com.codestates.burgerqueenspring.product.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WithoutSingletonTest {

    // 싱글톤 구현x
    @Test
    void runwithoutSingleton(){

        TestConfig testConfig = new TestConfig();

        ProductRepository productRepository = testConfig.productRepository();
        ProductRepository productRepository2 = testConfig.productRepository();

        System.out.println("productRepository = " + productRepository);
        System.out.println("productRepository2 = " + productRepository2);

        // 생성한 두 객체가 다른 참조값인지 검증
        Assertions.assertThat(productRepository).isNotSameAs(productRepository2);

    }

    static class TestConfig{

        public ProductRepository productRepository(){
            return new ProductRepository();
        }
    }
}
