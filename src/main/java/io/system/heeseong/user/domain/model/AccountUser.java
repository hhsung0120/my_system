package io.system.heeseong.user.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
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

    @Override
    public String toString() {
        return "AccountUser{" +
                "idx=" + idx +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
