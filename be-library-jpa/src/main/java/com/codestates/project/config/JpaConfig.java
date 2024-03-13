package com.codestates.project.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

    // JPAQueryFactory 빈을 생성하는 메서드
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        // EntityManager를 이용하여 JPAQueryFactory 인스턴스를 생성하고 반환합니다.
        // JPAQueryFactory는 Querydsl을 사용하여 JPA 쿼리를 더 쉽고 편리하게 작성하고 실행하는 데 도움을 주는 클래스입니다.
        return new JPAQueryFactory(entityManager);
    }
}

