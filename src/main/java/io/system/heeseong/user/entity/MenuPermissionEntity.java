package io.system.heeseong.user.entity;

import io.system.heeseong.common.domain.entity.TimeEntity;
import io.system.heeseong.user.model.Menu;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "menu_permission")
public class MenuPermissionEntity extends TimeEntity {

    @Id @Column(name = "menu_permission_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_idx")
    private MenuEntity menuEntity;

    @Column(nullable = false)
    private String role;

    public MenuPermissionEntity() {
    }

    public Menu entityToValueObject(){
        return Menu.entityToValueObject()
                    .idx(idx)
                    .menuUri(menuEntity.getMenuUri())
                    .menuName(menuEntity.getMenuName())
                    .description(menuEntity.getDescription())
                    .build();
    }

    @Override
    public String toString() {
        return "MenuPermissionEntity{" +
                "idx=" + idx +
                ", menuEntity=" + menuEntity +
                ", role='" + role + '\'' +
                '}';
    }
}