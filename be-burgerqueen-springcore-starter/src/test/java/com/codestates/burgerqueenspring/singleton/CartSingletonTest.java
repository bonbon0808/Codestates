package com.codestates.burgerqueenspring.singleton;

import com.codestates.burgerqueenspring.AppConfigurer;
import com.codestates.burgerqueenspring.Cart;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartSingletonTest {

    @Test
    void checkCartSingleton(){

        // 빈 컨테이너 생성 (given)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurer.class);

        // 빈 조회 (when)
        Cart cart = applicationContext.getBean("cart", Cart.class);
        Cart cart2 = applicationContext.getBean("cart", Cart.class);

        System.out.println("cart = " + cart);
        System.out.println("cart2 = " + cart2);

        // 검증 (then)
        Assertions.assertThat(cart).isSameAs(cart2);

    }
}
