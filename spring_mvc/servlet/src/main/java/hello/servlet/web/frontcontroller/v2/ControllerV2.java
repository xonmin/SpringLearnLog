package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    //render를 myview에서 해주기 위해 return 타입 MYview
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
