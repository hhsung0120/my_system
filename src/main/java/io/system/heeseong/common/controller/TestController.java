package io.system.heeseong.common.controller;

import io.system.heeseong.common.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    final MenuService menuService;

    @GetMapping("/menuList")
    public String menuList(){
        menuService.getMenuList();
        return "d";
    }
}
