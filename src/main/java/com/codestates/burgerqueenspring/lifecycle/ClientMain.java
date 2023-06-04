package com.codestates.burgerqueenspring.lifecycle;

import com.codestates.burgerqueenspring.AppConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientMain {
    public static void main(String[] args) {

        //컨테이너 생성
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClientConfig.class);

        //컨테이너 사용
        TestClient testClient = applicationContext.getBean("testClient", TestClient.class);
        testClient.connect();

        //컨테이너 종료
        applicationContext.close();


    }
}
