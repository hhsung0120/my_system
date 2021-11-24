package io.system.heeseong.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@ToString
//public class AccountUser extends User {
public class AccountUser{
    private String idx;
    private String email;
    private String password;
    private String userName;
    private String userAuth;

    public AccountUser() {
    }

    @Builder(builderMethodName = "entityToValueObject")
    public AccountUser(String idx, String email, String password, String userName, String userAuth) {
        this.idx = idx;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.userAuth = userAuth;
    }

//    public AccountUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, authorities);
//    }
//
//    public AccountUser(String email, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
//        super(userName, password, authorities);
//        this.email = email;
//    }
//
//    @Builder(builderMethodName = "entityToValueObject")
//    public AccountUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String idx, String email) {
//        super(username, password, authorities);
//        this.idx = idx;
//        this.email = email;
//    }
}
