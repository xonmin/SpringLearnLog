package com.example.study.Controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // LocalHost :8000/api

public class GetController {
 // 주소 창에 파라미터가 노출된다.
    // 브러우저에서 주소에 대한 캐시가 이루어지므로, 정보를 얻을 때 사용한다.
   @RequestMapping(method =RequestMethod.GET, path ="/getMethod") // LocalHost:8080/api/getMethod


        public String getRequest () {

            return " Hi getMethod";
    }

    @GetMapping("/getParameter") // localhost:8080/api/getParameter?id=1234&pw=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name ="pw") String pwd){
        String pw = "bbbb";

        System.out.println("id : "+id);
        System.out.println("pwd : "+pwd);

        return id+pwd;
    }
    //localhost:8080/api/multiParameter?account=abcd&email=xonmin@gamil.com
    // 받는 파라미터의 수가 계속 변할 때
    @GetMapping("/getMultiParameter")
    public String getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";
    }

    @GetMapping("/header")
    public Header getHeader(){

       return Header.builder().resultCode("OK").description("OK").build();
   }
    }

