package io.system.heeseong.user.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
//public class AccountUser extends User {
public class AccountUser{
    private Long idx;
    private String email;
    private String password;
    private String userName;
    private String status;
    private String role;

    public AccountUser() {
    }

    @Builder(builderMethodName = "entityToValueObject")
    public AccountUser(Long idx, String email, String password, String userName, String status, String role) {
        this.idx = idx;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.status = status;
        this.role = role;
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
