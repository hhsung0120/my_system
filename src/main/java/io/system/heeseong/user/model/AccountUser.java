package io.system.heeseong.user.model;

import lombok.Builder;
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

    @Builder(builderMethodName = "entityToValueObject")
    public AccountUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String idx, String email) {
        super(username, password, authorities);
        this.idx = idx;
        this.email = email;
    }
}
