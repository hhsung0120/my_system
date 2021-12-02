package io.system.heeseong.user.controller;

import io.system.heeseong.common.service.MenuService;
import io.system.heeseong.user.model.AccountUser;
import io.system.heeseong.user.service.AccountUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class AccountUserController {

    private Long authExpireTime = 0L;
    final AccountUserService accountUserService;
    final MenuService menuService;

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public Long login(@ModelAttribute AccountUser accountUser){
        return accountUserService.getAccountUserIdx(accountUser);
    }

    @ResponseBody
    @GetMapping("/timeTest")
    public String time(){
        Long currentTime = System.currentTimeMillis();
        Long hour = 60 * 60 * 1000L;

        System.out.println("===============");
        System.out.println("currentTime => " + currentTime);
        System.out.println("더하기 => ");
        System.out.println(authExpireTime + hour);
        System.out.println("===============");
        if (currentTime > authExpireTime + hour) {
//            adminAuthMap.computeIfAbsent(level, (adminAuthList) -> getAdminMenuList(level));
            authExpireTime = currentTime;
            System.out.println("sdfsdfsdfsdfsdf");
        }else{
            System.out.println("sdfsdf");
        }

        return "timeTest";
    }

    @ResponseBody
    @GetMapping("/menuTest")
    public String menu(){
        menuService.getMenuList();
        return "menuTest";
    }
}
