package com.codestates.burgerqueenspring.lifecycle;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestClient { // 인터페이스 구현 부분 삭제

    private String url;

    public TestClient(String url){
        System.out.println("생성자 호출.");
        this.url = url;
    }

    @PostConstruct
    public void init() { // 메서드 오버라이딩 정의한 afterPropertiesSet() 삭제 후 init()
        System.out.println("init() 초기화 메서드 실행.");
    }

    public void connect(){
        System.out.println("클라이언트를 " + url + " 로 연결.");
    }

    @PreDestroy
    public void close() { // destroy() 삭제 후 close()
        System.out.println("close() 종료 메서드 실행.");
    }
}

