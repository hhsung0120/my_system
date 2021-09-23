package io.system.heeseong.user.service;

import io.system.heeseong.user.model.AccountUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class LoginService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("userId {}", userId);

        List<GrantedAuthority> roles = new ArrayList<>();
        if ("user".equals(userId)) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if ("admin".equals(userId)) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
          return null;
        }

        return new User(userId, userId, roles);
    }

    public AccountUser getAccountUser(String userId, String password){
        log.info("userId {}", userId);
        log.info("password {}", password);

        String userName = "test";
        List<GrantedAuthority> roles = new ArrayList<>();
        if ("user".equals(userId)) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if ("admin".equals(userId)) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return new AccountUser(userId, userName, password, roles);
    }
}
