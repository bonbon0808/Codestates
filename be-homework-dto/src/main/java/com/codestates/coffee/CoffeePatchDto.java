package com.codestates.coffee;

import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class CoffeePatchDto {

    private long coffeeId;

    //@Nullable -> 넣어도 안넣어도 결과값은 똑같이 null로 나옴..

    // 공백 비허용 NotBlank나 NotNull NotEmpty를 쓰면 공백인 경우 Bad request가 뜸, 공백은 안되면서 선택적으로 포함되게 해야함
    @Pattern(regexp = "^\\S+$",
            message = "필수 항목입니다.")
    private String korName;

    //@Nullable
    @Pattern(regexp = "^[a-zA-Z]+(\\s?[a-zA-Z])*$", // 공백은 x. 영문으로 시작하고, 그 뒤에 공백과 영문이 0개 이상 올 수 있다는 의미
            message = "필수 항목입니다. 한 칸의 공백만 포함될 수 있습니다.")
    private String engName;

    //@Nullable
    @Range(min=100, max=50000,
            message = "1000원 이싱 50000원 이하여야 합니다.")
    private String price;

    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }


    public String  getKorName() {
        return korName;
    }


    public void setKorName(String korName) {
        this.korName = korName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
