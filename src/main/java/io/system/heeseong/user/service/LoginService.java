package io.system.heeseong.user.service;

import io.system.heeseong.common.util.CryptoUtil;
import io.system.heeseong.user.entity.AccountUserEntity;
import io.system.heeseong.user.model.AccountUser;
import io.system.heeseong.user.reposiroty.AccountUserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class LoginService implements UserDetailsService {

    @Autowired
    private AccountUserRepository accountUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public AccountUser getAccountUser(String email, String password){
        AccountUserEntity accountUserEntity = accountUserRepository.findByEmail(email);
        System.out.println(new BCryptPasswordEncoder().matches(password, accountUserEntity.getPassword()));

        log.info("all {}", accountUserEntity.toString());

        String userName = "test";
        List<GrantedAuthority> roles = new ArrayList<>();


//        if ("user".equals(email)) {
//            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//        } else if ("admin".equals(email)) {
//            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        }


        return new AccountUser(email, userName, password, roles);
    }
}
