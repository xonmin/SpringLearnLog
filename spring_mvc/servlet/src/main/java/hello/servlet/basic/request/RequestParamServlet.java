package hello.servlet.basic.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
    1. 파라미터 전송 기능
    http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("---- 전체 파라미터 조회 - start --------");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " =" + request.getParameter(paramName)));

        //단일 파라미터 조회
         String username = request.getParameter("username");
         String age =  request.getParameter("age");

        System.out.println(username + age);

        // 하나의 파라미터에 여러가지 값을 넣어서 전달할 수 있음
        // 하지만 내부 우선순위에 대해 가져오는 것이 다르다.

        //http://localhost:8080/request-param?username=hello&age=20&username=hello2

        // 여러 값을 가지므로 retrun 은 배열로 받아진다.
        String[] usernames = request.getParameterValues("username");
        for(String name : usernames){
            System.out.println(name);
        }
    }
}
