package com.codestates.burgerqueenspring;

import com.codestates.burgerqueenspring.order.Order;
import com.codestates.burgerqueenspring.order.OrderApp;
import com.codestates.burgerqueenspring.product.Product;
import com.codestates.burgerqueenspring.product.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

//        AppConfigurer appConfigurer = new AppConfigurer();
//
//                OrderApp orderApp = new OrderApp(
//                appConfigurer.productRepository(),
//                appConfigurer.menu(),
//                appConfigurer.cart(),
//                appConfigurer.order()
//        );

        // 스프링 컨테이너
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfigurer.class);

        // 스프링 빈 조회
        ProductRepository productRepository = applicationContext.getBean("productRepository", ProductRepository.class);
        Menu menu = applicationContext.getBean("menu", Menu.class);
        Cart cart = applicationContext.getBean("cart", Cart.class);
        Order order = applicationContext.getBean("order", Order.class);

        // 불러온 빈 사용
        OrderApp orderApp = new OrderApp(
                productRepository,
                menu,
                cart,
                order
        );

        orderApp.start();
    }
}