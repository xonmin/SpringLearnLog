package com.example.study.Controller;


import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    //HTML <Form>
    // ajax 검색
    // http post body -> data
    //json, xml, multipart-form / text-plain 형태 다 가능
    /*
    *   Rest의 개념
    *  http 프로토콜에 있는 method를 활용한 아키텍처 스타일
    * http method 를 톤ㅇ해서 resource 를 처리
    * crud 를 통한 resource 조작시, 사용
    *
    * */

    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
      // body 에 담긴 data를 받는다.

      return searchParam;
  }

  @PutMapping("/putMethod")
  public void put(){


  }


  @PatchMapping("/patchMethod")
  public void patch(){

  }

}
