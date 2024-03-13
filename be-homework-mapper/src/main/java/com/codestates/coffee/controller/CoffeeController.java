package com.codestates.coffee.controller;


import com.codestates.coffee.dto.CoffeePatchDto;
import com.codestates.coffee.dto.CoffeePostDto;
import com.codestates.coffee.dto.CoffeeResponseDto;
import com.codestates.coffee.entity.Coffee;
import com.codestates.coffee.mapper.CoffeeMapper;
import com.codestates.coffee.service.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v5/coffees")
@Validated
public class CoffeeController {

    private final CoffeeService coffeeService;

    private final CoffeeMapper mapper;

    public CoffeeController(CoffeeService coffeeService, CoffeeMapper mapper){
        this.coffeeService = coffeeService;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {
        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.
        // coffeePostDto를 매개변수로하는 coffeePostDtoToCoffee() 메서드 호출 , DTO<-> 엔티티 변환
        Coffee coffee = mapper.coffeePostDtoToCoffee(coffeePostDto);

        // createCoffee()에서 전달받은 coffee 매개변수로 커피 정보 생성 (입력된 내용으로 Coffee 객체가 만들어지는듯)
        Coffee response = coffeeService.createCoffee(coffee);

        //response 객체의 필드 값을 사용하여 CoffeeResponseDto의 인스턴스 생성하고, 필드 값을 복사하여 설정한 후 반환
        // createCoffee()로 만들어진 새로운 커피 정보를 반환
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);

        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.

        // updateCoffee()에서 전달받은 coffee를 매개변수로 커피 정보 수정
        Coffee response =
                coffeeService.updateCoffee(mapper.coffeePatchDtoToCoffee(coffeePatchDto));

        // 수정한 커피 정보 반환
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.

        // 커피 조회
        Coffee response = coffeeService.findCoffee(coffeeId);

        // 조회한 커피 정보 반환
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.

        // 모든 커피 정보를 받아와야 하니까 List로 선언
        List<Coffee> coffees = coffeeService.findCoffees();

        // 반환 정보 저장할 값도 List
        List<CoffeeResponseDto> response =
                coffees.stream()
                        .map(coffee -> mapper.coffeeToCoffeeResponseDto(coffee)) // CoffeeResponseDto 값 반환
                        .collect(Collectors.toList());

        // 조회한 커피 정보 반환
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        // TODO CoffeeService 클래스와 연동하세요.
        // TODO DTO <-> Entity 변환 Mapper를 적용하세요.

        // 커피 정보 삭제
        coffeeService.deleteCoffee(coffeeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
