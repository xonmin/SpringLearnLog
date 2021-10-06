package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // [status-line]
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); //200 return

        // [response-headers]
        resp.setHeader("Content-Type", "text/plain");
        resp.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //캐시 무효화 헤더
        resp.setHeader("Pragma", "no-cache"); // 캐시 과거버전까지 캐시를 다 없앤다.
        resp.setHeader("my-heahder","hello"); //임의의 헤더 생성


        redirect(resp);
        //[header의 편의 메서드]
        content(resp);
        cookie(resp);
        PrintWriter writer =  resp.getWriter();
        writer.println("OK");
    }

    private void content(HttpServletResponse response){
        response.setHeader("Content-Type", "text/plain");
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response){
       Cookie cookie = new Cookie("myCookie","good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_FOUND); // 302 redirect
        response.sendRedirect("/basic/hello-form.html");
    }
}
