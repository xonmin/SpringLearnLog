package com.example.xonmin.springbootstart.demo;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HolomanProperties.class)
public class HolomanConfiguration {

    @Bean //holoman return하는 빈
    @ConditionalOnMissingBean  // 컴포넌트스캔으로 먼저 등록한 빈이 있다면 오토컨피규어로는 빈을 등록하지 말게끔 설정
    public Holoman holoman(HolomanProperties properties){
        Holoman holoman = new Holoman();
        holoman.setHowLong(properties.getHowLong());
        holoman.setName(properties.getName());
        return holoman;
    }

}
