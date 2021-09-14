package io.system.heeseong.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portfolio")
public class HomeController {

    @GetMapping("/main")
    public String home(){
        return "/portfolio/main";
    }
}
