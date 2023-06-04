package com.codestates.burgerqueenspring.discount.discountPolicy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixedAmount")
public class FixedAmountDiscountPolicy implements DiscountPolicy {

    private int discountAmount = 500;

    public int calculateDiscountedPrice(int price) {
        return price - discountAmount;
    }
}
