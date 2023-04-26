package com.codestates.burgerqueenspring.order;

import com.codestates.burgerqueenspring.Cart;
import com.codestates.burgerqueenspring.discount.Discount;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Order {
    private Cart cart;
    private Discount discount;

    public Order(Cart cart, Discount discount) {
        this.cart = cart;
        this.discount = discount;
    }

    public void makeOrder() {

        log.info("⭐️ 메서드 호출️ ⭐");
        log.info("============= 메서드명 = makeOrder =============");
        log.info("[파라미터] = 없음");

        discount.checkAllDiscountConditions();

        int totalPrice = cart.calculateTotalPrice();

        int finalPrice = discount.discount(totalPrice);

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        cart.printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", totalPrice);
        System.out.printf("할인 적용 금액 : %d원\n", finalPrice);
    }
}
