package hello.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody = {}", messageBody);

        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody = {}", messageBody);

        responseWriter.write("ok");
    }

    //이제부터 진짜
    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
        /*
        HttpEntity  -> http header / body 정보를 편리하게 조회
            - 메시지 바디 정보 직접 조회
            - 요청 파라미터를 조회하는 기능과 관계 없음 (@RequestParam X , @ModelAttribute X)
            - 응답
                - 메시지 바디 정보 직접 반환
                - 헤더 정보 포함 가능
                - view 조회 X
         */
        String body = httpEntity.getBody();
        log.info("messageBody = {}", body);

        return new HttpEntity<>("OK");
    }

    //이제부터 진짜
    @PostMapping("/request-body-string-v3_2")
    public HttpEntity<String> requestBodyStringV3_2(RequestEntity<String> httpEntity) throws IOException {
        /*
        HttpEntity 를 상속 받은 객체
            - RequestEntity :
                httpmethod , url 정보 추가
            - ResponseEntity :
                statusCode 설정 및 응답에서 사용
         */
        String body = httpEntity.getBody();
        log.info("messageBody = {}", body);

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    //이제부터 진짜
    @ResponseBody //응답은 responsebody 로
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) throws IOException {
        /*
            끝판왕
            @ResponseBody 를 사용하면 http 메시지 바디 정보를 편리하게 조회 가능
            참고로 헤더 정보가 필요하다면 , HttpEntity 혹은 @RequestHeader를 사용하면된다.

         */

        log.info("messageBody = {}", messageBody);
        return "OK";
    }
}
