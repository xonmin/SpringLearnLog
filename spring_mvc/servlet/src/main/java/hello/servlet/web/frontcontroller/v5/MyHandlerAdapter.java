package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    //handler는 컨트롤러 - 해당 컨트롤러를 처리할 수 있는지
    boolean supports(Object handler);

    // 어댑터 - 실제 컨트롤러 호출 및 modelview 반환
    // 만약 반환하지 못하면 어댑터는 모델뷰 직접 생성 후 반환
    // 이전 버전은 프론트 컨트롤러가 실제 컨트롤러를 호출
    // 어뎁터를 통해 실제 컨트롤러가 호출
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

}
