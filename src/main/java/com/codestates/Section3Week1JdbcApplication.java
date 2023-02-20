package com.codestates;

import com.codestates.order.dto.OrderCoffeeDto;
import com.codestates.order.dto.OrderPostDto;
import com.codestates.order.entity.Order;
import com.codestates.order.mapper.OrderMapper;
import com.codestates.order.service.OrderService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Section3Week1JdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section3Week1JdbcApplication.class, args);
	}

//	@Bean
//	public ApplicationRunner testJpaBasicRunner(OrderMapper orderMapper, OrderService orderService) {
//
//		return args -> {
//			List<OrderCoffeeDto> orderCoffeeDtoList = List.of(
//					new OrderCoffeeDto(1, 2)
//			);
//			OrderPostDto orderPostDto = new OrderPostDto(1, orderCoffeeDtoList);
//			Order order = orderMapper.orderPostDtoToOrder(orderPostDto);
//			orderService.createOrder(order);
//		};
//	}
}
