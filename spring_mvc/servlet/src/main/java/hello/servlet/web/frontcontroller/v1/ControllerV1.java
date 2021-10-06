package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    // interface를 사용하는 이유 다형성을 적극적으로 사용하기 위해서

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
