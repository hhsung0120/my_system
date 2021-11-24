package io.system.heeseong.user.service;

import io.system.heeseong.common.exception.LoginFailException;
import io.system.heeseong.user.entity.AccountUserEntity;
import io.system.heeseong.user.model.AccountUser;
import io.system.heeseong.user.reposiroty.AccountUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class AccountUserService {

    final AccountUserRepository accountUserRepository;

    public AccountUser getAccountUser(AccountUser accountUser){
        AccountUserEntity accountUserEntity =
                Optional.ofNullable(accountUserRepository.findByEmail(accountUser.getEmail()))
                        .orElseThrow(() -> new LoginFailException(LoginFailException.Message.LOGIN_FAIL_EXCEPTION));

        if(!new BCryptPasswordEncoder().matches(accountUser.getPassword(), accountUserEntity.getPassword())){
            throw new LoginFailException(LoginFailException.Message.LOGIN_FAIL_EXCEPTION);
        }

        log.info("all {}", accountUserEntity.toString());


        String userName = "test";

        return null;
    }
}
