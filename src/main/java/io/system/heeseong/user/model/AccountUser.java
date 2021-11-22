package io.system.heeseong.user.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@ToString
public class AccountUser extends User {

    private String idx;
    private String email;

    public AccountUser(String email, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userName, password, authorities);
        this.email = email;
    }
}
