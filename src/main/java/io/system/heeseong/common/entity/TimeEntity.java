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

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createDate;

    private String lastModifiedUser;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    public TimeEntity() {
    }

    public TimeEntity(String createUser) {
        this.createUser = createUser;
    }
}
