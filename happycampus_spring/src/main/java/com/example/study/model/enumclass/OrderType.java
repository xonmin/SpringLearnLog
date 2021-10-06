package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {

    ALL(0,"묶음","묶어서 주문"),
    EACH(1,"개별","개별 주문")
    ;

    private Integer id;
    private String title;
    private String description;
}
