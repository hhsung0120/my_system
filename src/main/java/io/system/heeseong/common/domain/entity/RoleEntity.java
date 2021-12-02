package io.system.heeseong.common.domain.entity;

import io.system.heeseong.common.domain.model.Role;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Entity
@Table(name = "role")
public class RoleEntity extends TimeEntity {

    @Id @Column(name = "role_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String roleName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String useYn;

    public RoleEntity() {
    }

    public Role entityToValueObject(){
        return Role.entityToValueObject()
                    .idx(idx)
                    .roleName(roleName)
                    .description(description)
                    .useYn(useYn)
                    .build();
    }
}