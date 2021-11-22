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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public AccountUser getAccountUser(String email, String password){
        log.info("email {}", email);
        log.info("password {}", password);

        String userName = "test";
        List<GrantedAuthority> roles = new ArrayList<>();
        if ("user".equals(email)) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if ("admin".equals(email)) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return new AccountUser(email, userName, password, roles);
    }
}
