package io.system.heeseong.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class AccountUserController {

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }
}
