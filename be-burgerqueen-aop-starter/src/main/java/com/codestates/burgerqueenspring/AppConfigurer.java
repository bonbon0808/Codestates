package com.codestates.burgerqueenspring;

import com.codestates.burgerqueenspring.discount.Discount;
import com.codestates.burgerqueenspring.order.Order;
import com.codestates.burgerqueenspring.product.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfigurer {
    @Bean
    public Cart cart(){
        return new Cart(productRepository(), menu());
    }

    @Bean
    public Menu menu() {
        return new Menu(productRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public Order order() {
        return new Order(cart(), discount());
    }

    @Bean
    public Discount discount() {
        return new Discount();
    }

}
