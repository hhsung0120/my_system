package io.system.heeseong.common.controller;

import io.system.heeseong.user.domain.model.Menu;
import io.system.heeseong.user.service.AccountUserService;
import io.system.heeseong.user.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private Long authExpireTime = 0L;

    final AccountUserService accountUserService;
    final MenuService menuService;

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
    @GetMapping("/timeTest2")
    public String time2(){
        LocalDateTime test = LocalDateTime.now();
        LocalDateTime test2 = test.plusMinutes(20);

        boolean tt = test.isAfter(test2);

        System.out.println(tt);


        return "timeTest";
    }

    @ResponseBody
    @GetMapping("/menuList")
    public List<Menu> menuList(){
        return accountUserService.getMenuPermissionList();
    }

    @ResponseBody
    @GetMapping("/set-menuList")
    public List<Menu> setMenuList(){
        return accountUserService.getMenuPermissionList();
    }

    @ResponseBody
    @GetMapping("/reload-menuList")
    public String reloadMenuList(){
        accountUserService.reloadMenuPermissionList();
        return "호출 완료";
    }

}
