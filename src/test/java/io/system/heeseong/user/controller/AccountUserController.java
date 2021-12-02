package io.system.heeseong.user.controller;

import io.system.heeseong.common.service.MenuService;
import io.system.heeseong.common.util.CryptoUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountUserController {

    @Autowired
    private MenuService menuService;

    @Test
    public void passwordHash() {
        System.out.println(CryptoUtil.encryptPassword("gksgmltjd1!"));
        System.out.println(CryptoUtil.encryptPassword("gksgmltjd1!"));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("gksgmltjd1!"));
        System.out.println(bCryptPasswordEncoder.matches("gksgmltjd1!", "$2a$10$nGytNer4Aisc1G8GI6q8.Oya6eoq5sdfDCaS1SI1915ufn7iYyiAt4PW"));
    }

    @Test
    public void getMenuList() {
        menuService.getMenuList();
    }

    @Test
    public void setMenuList() {
        menuService.setMenuList();
    }
}
