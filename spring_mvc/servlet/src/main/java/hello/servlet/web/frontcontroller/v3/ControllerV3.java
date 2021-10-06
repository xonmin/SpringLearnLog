package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    //Servlet 기술 X  -> http 서블릿 없음
    ModelView process(Map<String, String> paramMap);

}
