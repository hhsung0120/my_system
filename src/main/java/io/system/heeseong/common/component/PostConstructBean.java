package io.system.heeseong.common.component;

import io.system.heeseong.common.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostConstructBean {

    final MenuService menuService;

    @PostConstruct
    public void init(){
        menuService.setMenuList();
    }
}
