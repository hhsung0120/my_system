package io.system.heeseong.common.controller;

import io.system.heeseong.common.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommonController {

    final MenuService menuService;

    @GetMapping("/common/reload/menu")
    public String setMenuList(){
        menuService.setMenuList();
        return "";
    }
}
