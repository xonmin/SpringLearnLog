package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * {"username":"hello", "age":20}
 * content-type: application/json
 */

/*
@ResponseBody
응답의 경우 : @ResponseBody를 사용하면 해당 객체를 http 메시지 바디에 직접 넣어줄 수 있음
이 때 httpEntity 사용 가능

@RequestBody 요청 : JSON 요청 -> Http 메시지 컨버터 -> 객체
             응답 : 객체 -> http 메시지 컨버터 -> JSON 응답
 */


@Slf4j
@Controller


public class RequestBodyJsonController {

    //json이기 떄문에 objectMapper 가 필요함

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody ={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username ={}, age = {}", helloData.getUsername(), helloData.getAge());

        response.getWriter().write("OK");
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {

        log.info("messageBody ={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username ={}, age = {}", helloData.getUsername(), helloData.getAge());

        return "ok";

        //문자로 변환하고 다시 json으로 변환하는 것이 불편따라서 @ModelAttribute처럼 한 번에 객체로 변환하는 방법을 찾아야함
    }


    // RequestBody에 단순한 자료형이 아닌 객체가 직접 들어오면,
    // 자동으로 httpMessageConverter가 바디의 내용을 우리가 원하는 객체나 문자로 자동 변환해준다.
    // 자세하게는 MappingJackson2HttpMessageConverter가 동작
    /*
    @RequestBody 생략 불가능
    스프링은 @ModelAttribute, @RequestParam 해당 생략시 다음과 같은 규칙 적용
    1. String, int, Integer 단순 타입 = @RequestParam
    나머지 - @ModelAttribute

    따라서 이 경우 HelloData에 @RequestBody 생략하면 @ModelAttribute가 적용되어
    http 메시지 바디가 아니라 요청 파라미터를 처리하게 됨
     */

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData helloData) {
        log.info("username ={}, age = {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }


    // HttpEntity 사용해서 뽑기
    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyJsonV4(HttpEntity<HelloData> helloData) {
        HelloData body = helloData.getBody();
        log.info("username ={}, age = {}", body.getUsername(), body.getAge());
        return "ok";
    }

    // return 도 httpMessageConverter가  자동으로 반환해서 리턴해준다.
    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData helloData) {
        log.info("username ={}, age = {}", helloData.getUsername(), helloData.getAge());
        return helloData;
    }


}
