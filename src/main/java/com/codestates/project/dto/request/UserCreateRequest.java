package com.codestates.project.dto.request;

import com.codestates.project.domain.Gender;
import com.codestates.project.domain.UserInfo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * 사용자 등록 요청을 나타내는 클래스인 UserCreateRequest입니다.
 * 사용자 등록 시 필요한 정보를 가지고 있습니다.
 */
public class UserCreateRequest {

    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String name; // 사용자 이름

    @Positive(message = "나이는 양수만 가능합니다.")
    private Integer age; // 사용자 나이

    private Gender gender; // 사용자 성별

    @NotBlank(message = "전화번호는 필수 입력값입니다.")
    private String phone; // 사용자 전화번호

    /**
     * UserCreateRequest의 생성자입니다.
     * @param name 사용자 이름
     * @param age 사용자 나이
     * @param gender 사용자 성별
     * @param phone 사용자 전화번호
     */
    public UserCreateRequest(String name, Integer age, Gender gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    /**
     * 사용자 이름을 반환합니다.
     * @return String 사용자 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 사용자 나이를 반환합니다.
     * @return Integer 사용자 나이
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 사용자 성별을 반환합니다.
     * @return Gender 사용자 성별
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * 사용자 전화번호를 반환합니다.
     * @return String 사용자 전화번호
     */
    public String getPhone() {
        return phone;
    }

    /**
     * UserCreateRequest 객체를 UserInfo 엔티티로 변환하여 반환합니다.
     * @return UserInfo 사용자 정보 엔티티
     */
    public UserInfo toEntity() {
        return new UserInfo(name, age, gender, phone);
    }
}
