package io.system.heeseong.user.controller;

import io.system.heeseong.common.domain.model.ResponseData;
import io.system.heeseong.common.service.CodeService;
import io.system.heeseong.user.domain.model.AccountUser;
import io.system.heeseong.user.service.AccountUserService;
import io.system.heeseong.user.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class AccountUserController {

    final AccountUserService accountUserService;
    final CodeService codeService;
    final MenuService menuService;

    @GetMapping("/login")
    public String login(){
        if(accountUserService.isLogin()){
            return "redirect:/portfolio/main";
        }

        return "/user/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseData login(@ModelAttribute AccountUser accountUser){
        accountUserService.getAccountUser(accountUser);
        return new ResponseData(codeService.getCode("login_success"));
    }

    @ResponseBody
    @GetMapping("/{userIdx}")
    public Long users(@PathVariable Long userIdx){
        return userIdx;
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        accountUserService.logout();
        return new ModelAndView("redirect:/");
    }

}
