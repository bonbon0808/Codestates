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

    // 왜 AggregateRef로 감싸지 않는가? --> Order에서 CoffeeRef에 이미 접근 가능하므로..
    // 이것만 기억합시다. -> 어떤 객체에 접근하기 위해서는 접근하려는 객체의 참조값만 있으면 된다.
    private long coffeeId;
    private int quantity;

    // 왜 private long orderId는 없는가? --> Order가 private Set<CoffeeRef> orderCoffees로 이미 참조 가능하므로..
}
