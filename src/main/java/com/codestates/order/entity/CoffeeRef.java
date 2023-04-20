package com.codestates.order.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder
@Table("ORDER_COFFEE")
public class CoffeeRef {
    @Id
    private long orderCoffeeId;

    // 왜 AggregateReference로 감싸지 않는가?
    // --> Coffee와 CoffeeRef는 애그리거트 루트 간의 관계가 아니다.
    // --> CoffeeRef 자체가 coffeeId를 감싼 참조 객체의 역할을 한다.
    private long coffeeId;
    private int quantity;

    // 왜 private long orderId는 없는가?
    // --> Order가 private Set<CoffeeRef> orderCoffees로 이미 참조 가능하므로..
    // --> 즉, CoffeeRef가 이미 Order와 외래키의 관계를 가진다는 의미임.
}
