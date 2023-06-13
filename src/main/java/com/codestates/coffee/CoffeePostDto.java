package com.codestates.coffee;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CoffeePostDto {


    @NotBlank  // 필수항목, 공백만으로 구성x
    private String korName;

    @NotBlank // 필수항목, 공백만으로 구성x
    @Pattern(regexp = "^[a-zA-Z]+(\\s?[a-zA-Z])*$",
            message = "필수 항목입니다. 한 칸의 공백만 포함될 수 있습니다.") //"^[a-zA-Z]+( [a-zA-Z]+)*$") -> 이 표현도 잘되네
    private String engName;

    @Range(min=100, max= 50000,
            message = "1000원 이상 50000원 미만이어야 합니다.")
    private String price;

    public String getKorName() {
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
