package io.system.heeseong.facebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacebookController {

    @GetMapping("/facebook/list")
    public String list() {
        return "/facebook/list";
    }

    @GetMapping("/facebook/test")
    public String test() {
        return "/facebook/test";
    }

    @GetMapping("/facebook/test2")
    public String test2() {
        return "/facebook/test2";
    }

    @GetMapping("/facebook/test3")
    public String test3() {
        return "/facebook/test3";
    }
}
