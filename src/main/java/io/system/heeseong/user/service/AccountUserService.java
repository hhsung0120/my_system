package io.system.heeseong.user.service;

import io.system.heeseong.common.exception.LoginFailException;
import io.system.heeseong.user.entity.AccountUserEntity;
import io.system.heeseong.user.model.AccountUser;
import io.system.heeseong.user.reposiroty.AccountUserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class AccountUserService {

    final AccountUserRepository accountUserRepository;
    final HttpSession httpSession;

    public AccountUser getAccountUser(AccountUser accountUser){
        AccountUserEntity accountUserEntity =
                Optional.ofNullable(accountUserRepository.findByEmail(accountUser.getEmail()))
                        .orElseThrow(() -> new LoginFailException(LoginFailException.Message.LOGIN_FAIL_EXCEPTION));

        if(!new BCryptPasswordEncoder().matches(accountUser.getPassword(), accountUserEntity.getPassword())){
            throw new LoginFailException(LoginFailException.Message.LOGIN_FAIL_EXCEPTION);
        }

        setSessionAccountUser(accountUserEntity.entityToValueObject());
        AccountUser tt = getSessionAccountUser();

        log.info("all {}", accountUserEntity.toString());
        return accountUserEntity.entityToValueObject();
    }

    public void setSessionAccountUser(AccountUser accountUser){
        httpSession.setAttribute("accountUser", accountUser);
    }

    public AccountUser getSessionAccountUser(){
        System.out.println("sdfsdfsdf????");
        AccountUser accountUser = (AccountUser)httpSession.getAttribute("accountUser");
        if(accountUser == null) return null;
        return accountUser;
//        return (AccountUser) Optional.ofNullable(httpSession.getAttribute("accountUser"))
//                        .orElseGet(null);
    }
}
