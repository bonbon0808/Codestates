package com.codestates.burgerqueenspring;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

//    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurer.class);

    @Test
    void fineBeanX2(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurer.class);

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean("xxx", Menu.class));

    }


//    @Test
//    void findBean() {

//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurer.class);

//        // 테스트 검증(Cart)
//        Cart cart = applicationContext.getBean("cart", Cart.class);
//
//        Assertions.assertThat(cart).isInstanceOf(Cart.class);


//        // 테스트 실패 검증
//        Menu menu = applicationContext.getBean("menu", Menu.class);
//
//        Assertions.assertThat(menu).isInstanceOf(Cart.class);

//    }
}
