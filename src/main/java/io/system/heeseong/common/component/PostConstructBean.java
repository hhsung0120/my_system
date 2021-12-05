package io.system.heeseong.common.component;

import io.system.heeseong.user.service.MenuService;
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
        //원래 이 타이밍에 모든 메뉴를 미리 셋팅 해 두려 했으나 다시 설계        
    }
}
