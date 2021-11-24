package io.system.heeseong.user.controller;

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

    final AccountUserService accountUserService;

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public AccountUser login(@ModelAttribute AccountUser accountUser){
        log.info("accountUser {}", accountUser.toString());
        accountUserService.getAccountUser(accountUser);
        return accountUser;
    }
}
