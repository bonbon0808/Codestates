package com.codestates.coffee.service;

import com.codestates.coffee.entity.Coffee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //  @Component도 가능 -> @Service보다 더 큰 범위를 가짐
public class CoffeeService {

    // createCoffee(Coffee coffee)
    // 등록할 커피 정보(Coffee 클래스 객체)
    // 리턴값 : 파라미터로 전달받은 Coffee 클래스 객체
    public Coffee createCoffee(Coffee coffee) {
        Coffee createdCoffee = coffee;
        return createdCoffee;
    }

    // updateCoffee(Coffee coffee)
    // 수정할 커피 정보(Coffee 클래스 객체)
    // 리턴값 : 파라미터로 전달받은 Coffee 클래스 객체

    public Coffee updateCoffee(Coffee coffee) {
        Coffee updatedCoffee = coffee;
        return updatedCoffee;
    }

    // findCoffee(long coffeeId)
    // 조회할 커피의 커피 식별자(long)
    // 리턴값 : Stub 데이터를 포함한 Coffee 클래스의 객체

    public Coffee findCoffee(long coffeeId) {
        Coffee coffee = new Coffee(coffeeId, "아메리카노", "Americano", "2500");
        return coffee;
    }

    // findCoffees()
    // 파라미터 x
    // 리턴값 : Stub 데이터를 포함한 List
    public List<Coffee> findCoffees() {

        List<Coffee> coffees = List.of(new Coffee(1L, "아메리카노", "Americano", "2500"), new Coffee(2L, "캐러멜 라떼", "Caramel Latte", "5000"));
        return coffees;
    }

    // deleteCoffee(long coffeeId)
    // 파라미터 x
    // 리턴 값 x

    public void deleteCoffee(long coffeeId) {

    }

}
