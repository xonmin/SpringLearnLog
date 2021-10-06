package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {


    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        //단순하게 뷰의 논리 이름만 반환하면 된다.
        //model은 frontcontroller가 생성해줄거야
        return "new-form";
    }
}
