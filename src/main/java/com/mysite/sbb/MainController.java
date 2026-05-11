package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    // @ResponseBody //아래 메소드가 리턴하는 값이 응답의 본문이 될 것이라고 지정하는  애너테이션
    public String index() {
        return "redirect:/question/list";
    }
}