package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody //아래 메소드가 리턴하는 값이 응답의 본문이 될 것이라고 지정하는  애너테이션
    public String index() {
        return "SBB";
    }


    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "ㅎㅇㅎㅇ ㅋㅋ ";
    }
}