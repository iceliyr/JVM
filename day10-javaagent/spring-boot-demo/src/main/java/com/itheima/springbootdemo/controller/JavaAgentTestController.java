package com.itheima.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * java -jar -javaagent:D:/jvm/itheima-jvm-java-agent-jar-with-dependencies.jar  .\spring-boot-demo-0.0.1-SNAPSHOT.jar
 */
@RestController
@Controller
public class JavaAgentTestController {

    @GetMapping("/test1")
    public String test1(String name) {
        return "test1";
    }
}
