package com.codestates.order;

import javax.validation.constraints.Positive;

public class OrderPostDto {
    @Positive
    private long memberId;

    @Positive
    private long coffeeId;

    public long getMemberId() {
        return memberId;
    }

    public long getCoffeeId() {
        return coffeeId;
    }
}
