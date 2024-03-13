package com.codestates.slice.controller.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest         // (1)
@AutoConfigureMockMvc   // (2)
public class ControllerTestDefaultStructure {
    // (3)
    @Autowired
    private MockMvc mockMvc;

    // (4)
    @Test
    public void postMemberTest() {
        // (5) given 테스트용 request body 생성

        // (6) when MockMvc 객체로 테스트 대상 Controller 호출

        // (7) then Controller 핸들러 메서드에서 응답으로 수신한 HTTP Status 및 response body 검증
    }
}
