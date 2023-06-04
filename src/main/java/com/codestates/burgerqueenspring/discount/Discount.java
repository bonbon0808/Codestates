package com.codestates.burgerqueenspring.discount;

import com.codestates.burgerqueenspring.discount.discountCondition.CozDiscountCondition;
import com.codestates.burgerqueenspring.discount.discountCondition.DiscountCondition;
import com.codestates.burgerqueenspring.discount.discountCondition.KidDiscountCondition;
import com.codestates.burgerqueenspring.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.codestates.burgerqueenspring.discount.discountPolicy.FixedRateDiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Discount {
    private DiscountCondition[] discountConditions;

//    public Discount(){
//        this.discountConditions = new DiscountCondition[]{
//                new CozDiscountCondition(new FixedRateDiscountPolicy()),
//                new KidDiscountCondition(new FixedAmountDiscountPolicy())
//        };
//    }

    public Discount(DiscountCondition[] discountConditions) {
        this.discountConditions = discountConditions;
    }

    public void checkAllDiscountConditions() {
        for (DiscountCondition discountCondition : discountConditions) {
            discountCondition.checkDiscountCondition();
        }
    }

    public int discount(int price) {

        int discountedPrice = price;

        for (DiscountCondition discountCondition : discountConditions) {
            if (discountCondition.isSatisfied()) discountedPrice = discountCondition.applyDiscount(discountedPrice);
        }

        return discountedPrice;
    }
}