package com.choimory.itemvaluechecker.api.itemapi.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
}
