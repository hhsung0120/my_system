package io.system.heeseong.common.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    private String createUser;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private String modifiedUser;

    @Column(nullable = false)
    private LocalDateTime modifiedDate;

    public TimeEntity() {
    }

    public void setCreateUserAndTime(String createUser){
        this.createUser = createUser;
        this.createDate = LocalDateTime.now();
        this.modifiedUser = createUser;
        this.modifiedDate = LocalDateTime.now();
    }
}
