package com.codestates.burgerqueenspring.singleton;

import com.codestates.burgerqueenspring.product.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    // 싱글톤 구현
    @Test
    void runWithSingleton() {

        TestConfig2 testConfig2 = new TestConfig2();

        ProductRepository productRepository = testConfig2.productRepository();
        ProductRepository productRepository2 = testConfig2.productRepository();

        // 생성된 두 객체가 같은 참조값인지 검증
        Assertions.assertThat(productRepository).isSameAs(productRepository2);
    }

    public class TestConfig2{

        private final ProductRepository productRepository = new ProductRepository();

        private TestConfig2(){}

            ProductRepository productRepository(){
                return productRepository;
            }
        }
    }

