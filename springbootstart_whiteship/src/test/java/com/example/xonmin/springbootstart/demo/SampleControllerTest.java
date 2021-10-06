package com.example.xonmin.springbootstart.demo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Rule
    public OutputCaptureRule outputCapture = new OutputCaptureRule(); // log를 비롯한 모든 것을 다 캡쳐하는 기능


    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    MockMvc mockMvc;

    @MockBean // ApplicationContext에 들어있는 빈을 Mock으로 만든 객체로 교체
    SampleService sampleService;

    @Test
    public void hello() throws Exception{
            mockMvc.perform(get("/hello"))
            .andExpect(status().isOk()) //밑에 프린트로 찍은 내용 response를 assertion 할 수 잇다.
            .andExpect(content().string("hello xonmin"))
                    .andDo(print());
    }
    @Test
    public void hello2() throws Exception{
        when(sampleService.getName()).thenReturn("xonmin");

        String result = testRestTemplate.getForObject("/hello",String.class);
        assertThat(result).isEqualTo("hello xonmin");
        assertThat(outputCapture.toString()).contains("holoman");
    }

}