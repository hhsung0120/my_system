package io.system.heeseong.common.config;

import io.system.heeseong.user.model.AccountUser;
import io.system.heeseong.user.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = (String)authentication.getPrincipal();
        String userPassword = (String)authentication.getCredentials();

        log.info("userId {}", userId);
        log.info("userPassword {}", userPassword);

        AccountUser accountUser = loginService.getAccountUser(userId, userPassword);
        System.out.println(accountUser.toString());
        System.out.println(accountUser.getUsername());
        System.out.println(accountUser.getAuthorities());
        return new UsernamePasswordAuthenticationToken(accountUser.getUsername(), accountUser.getPassword(), accountUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}