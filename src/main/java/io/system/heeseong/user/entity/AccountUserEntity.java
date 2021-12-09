package io.system.heeseong.user.entity;

import io.system.heeseong.common.code.UserStatusEnum;
import io.system.heeseong.user.model.AccountUser;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "account_user")
public class AccountUserEntity {

    @Id @Column(name = "user_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatusEnum status;

    @Column(nullable = false)
    private String role;

    public AccountUserEntity() {
    }

    @Override
    public String toString() {
        return "AccountUserEntity{" +
                "idx=" + idx +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", status=" + status +
                ", role='" + role + '\'' +
                '}';
    }

    public AccountUser entityToValueObject(){
        return AccountUser.entityToValueObject()
                            .idx(idx)
                            .email(email)
                            .userName(userName)
                            .status(status.toString())
                            .role(role)
                            .build();
    }
}
