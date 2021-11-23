package io.system.heeseong.user.entity;

import io.system.heeseong.common.enumcode.UserStatus;
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
    private UserStatus status;

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
}
