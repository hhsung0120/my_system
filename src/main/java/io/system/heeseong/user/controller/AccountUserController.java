package io.system.heeseong.user.controller;

import io.system.heeseong.user.model.AccountUser;
import io.system.heeseong.user.service.AccountUserService;
import io.system.heeseong.user.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class AccountUserController {

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
    @GetMapping("/{userIdx}")
    public Long users(@PathVariable Long userIdx){
        return userIdx;
    }
}
