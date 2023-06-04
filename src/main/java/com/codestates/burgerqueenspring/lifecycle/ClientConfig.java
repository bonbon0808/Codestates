package com.codestates.burgerqueenspring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean//(initMethod = "init", destroyMethod = "close") // initMethod 속성과 destroyMethod -> init close 메서드로 지정
    public TestClient testClient() {
        // 생성자로 url 주소값 전달
        TestClient testClient = new TestClient("www.codestates.com");
        return testClient;
    }


}
