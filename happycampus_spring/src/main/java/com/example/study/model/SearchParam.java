package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {
    private  String account;
    private  String email;
    private int page;


}
//lombok 을 통하여 아규먼트 설정하기 귀찮은 점을 줄일 수 잇다.
//jpa - orm(object relation mapping) 으로 RDB 데이터 베이스의 정보를 객체지향으로 손쉽게 활요하도록 하는 도구
// object 와 relation 맵핑 / 쿼리에 집중하기보다 객체에 집중