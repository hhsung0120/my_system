package io.system.heeseong.facebook;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private final static String appId = "563769071575128";
    private final static String appSecretCode = "6626454edf9a740792c51ae059b6e297";
    private final static String appToken = "933bbe2f304ee908b82e09663718841f";


    @GetMapping("/facebook/test")
    public String test(){
        return "/facebook/test";
    }

    @GetMapping("/facebook/test2")
    public String test2(){
        return "/facebook/test2";
    }
}
