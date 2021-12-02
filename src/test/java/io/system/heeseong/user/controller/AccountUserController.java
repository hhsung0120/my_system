package io.system.heeseong.user.controller;

import io.system.heeseong.common.util.CryptoUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class AccountUserController {

    @Test
    public void passwordHash() {
        System.out.println(CryptoUtil.encryptPassword("gksgmltjd1!"));
        System.out.println(CryptoUtil.encryptPassword("gksgmltjd1!"));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("gksgmltjd1!"));
        System.out.println(bCryptPasswordEncoder.matches("gksgmltjd1!", "$2a$10$nGytNer4Aisc1G8GI6q8.Oya6eoq5sdfDCaS1SI1915ufn7iYyiAt4PW"));
    }

}
