package io.system.heeseong.user.service;

import io.system.heeseong.common.exception.LoginFailException;
import io.system.heeseong.user.domain.entity.AccountUserEntity;
import io.system.heeseong.user.domain.model.AccountUser;
import io.system.heeseong.user.domain.reposiroty.AccountUserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Log4j2
public class LoginService implements UserDetailsService {

    @Autowired
    private AccountUserRepository accountUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public AccountUser getAccountUser(String email, String password){
        AccountUserEntity accountUserEntity =
                Optional.ofNullable(accountUserRepository.findByEmail(email))
                        .orElseThrow(() -> new LoginFailException(LoginFailException.Message.LOGIN_FAIL_EXCEPTION));

        if(!new BCryptPasswordEncoder().matches(password, accountUserEntity.getPassword())){
            throw new LoginFailException(LoginFailException.Message.LOGIN_FAIL_EXCEPTION);
        }

//        if ("user".equals(email)) {
//            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//        } else if ("admin".equals(email)) {
//            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        }
//        return new AccountUser(email, userName, password, roles);

        return null;
    }
}
