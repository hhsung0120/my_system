package io.system.heeseong.common.domain.entity;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeEntity {

    @Column(nullable = false)
    private Long createUser;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private Long updateUser;

    @Column(nullable = false)
    private LocalDateTime updateDate;

    public TimeEntity() {
    }

    public void setCreateUserAndTime(Long createUser){
        this.createUser = createUser;
        this.createDate = LocalDateTime.now();
        this.updateUser = createUser;
        this.updateDate = LocalDateTime.now();
    }
}
