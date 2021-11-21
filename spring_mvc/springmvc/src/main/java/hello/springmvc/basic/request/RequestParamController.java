package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamaV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {} , age = {}",username,age);

        response.getWriter().write("OK");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){
        log.info("username = {} , age = {}",memberName,memberAge);

        return "OK"; //@ResponseBody 는 @RestController와 같은 효과로 String을 반환할 떄 뷰를 찾는 것이 아닌 그저 String을 리턴하게 뙨다.
    }


    //param의 변수명을 생략하기 위해서는 url 에 있는 param 의 명과 함수에서 받는 변수명이 같으면된다.
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){
        log.info("username = {} , age = {}",username,age);

        return "OK"; //@ResponseBody 는 @RestController와 같은 효과로 String을 반환할 떄 뷰를 찾는 것이 아닌 그저 String을 리턴하게 뙨다.
    }


    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username = {} , age = {}",username,age);
        return "OK"; //@ResponseBody 는 @RestController와 같은 효과로 String을 반환할 떄 뷰를 찾는 것이 아닌 그저 String을 리턴하게 뙨다.
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = false) String username,
                                       @RequestParam(required = false) Integer age){

        // int의 기본형에는 null이 들어 갈 수 없기 때문에 자동으로 0이 들어간다.
        // 따라서 Integer로 선언하여야 null 이 들어가진다.

        // null 과 "" 은 다르다.
        log.info("username = {} , age = {}",username,age);
        return "OK"; //required 가 false 라면 파라미터를 안넣어줘도 된다.
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                       @RequestParam(required = false, defaultValue = "-1") Integer age){

        // int의 기본형에는 null이 들어 갈 수 없기 때문에 자동으로 0이 들어간다.
        // 따라서 Integer로 선언하여야 null 이 들어가진다.

        // null 과 "" 은 다르다.
        log.info("username = {} , age = {}",username,age);
        return "OK"; //required 가 false 라면 파라미터를 안넣어줘도 된다.
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamDefault(@RequestParam Map<String, Object> paramMap){

        // Map으로도 조회가 가능하다.
        log.info("username = {} , age = {}",paramMap.get("username"),paramMap.get("age"));
        return "OK";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        //modelAttribute 를 통해 자동으로 생성해주고 , 자동으로 객체의 프로퍼티를 찾고 바인딩해준다.

        log.info("helloData = {}",helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        //modelAttribute 없이써도 자동 생략해도 된다. data 클래스가 잇으면 자동으로 매핑해준다.

        log.info("helloData = {}",helloData);

        return "ok";
    }



    // String, int , Integer 같은 단순 타입 = @RequestParam
    // 나머지 = @ModelAttribute (argument resolver로 지정해둔 타입 외)
    // ex) HttpServletResponse

}
