package com.example.xonmin.springbootstart;


import com.example.xonmin.springbootstart.demo.Holoman;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

//springbootconfiguration + componentScan + EnableAutoConfiguration
public class SpringbootstartApplication {

//    public static void main(String[] args)  {
//      SpringApplication application = new SpringApplication(SpringbootstartApplication.class);
//      application.setWebApplicationType(WebApplicationType.SERVLET);  //기본적으로 서블릿으로 돈다.
//      application.run(args);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootstartApplication.class, args);
    }
}








