package com.tmnt.test.moshtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

//if not RestController it will act strings like file names
@Controller //annotations just extra data bruh . use it for static html serve
public class HomeHello {

    //accesing environmental variables
    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/try1")
    public String SayHello(){
        return "index.html";
    }

    @GetMapping("/try2")
    public Map<String,String> hello2(){
        return Map.of("hello","goodman");
    }
}
