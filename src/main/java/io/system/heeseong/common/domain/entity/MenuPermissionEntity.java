package io.system.heeseong.common.domain.entity;

import io.system.heeseong.common.domain.model.Menu;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "menu_permission")
public class MenuPermissionEntity extends TimeEntity {

    @Id @Column(name = "menu_permission_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne
    @JoinColumn(name = "menu_idx")
    private MenuEntity menuEntity;

    @Column(nullable = false)
    private String role;

    public MenuPermissionEntity() {
    }

    public Menu entityToValueObject(){
        return Menu.entityToValueObject()
                    .idx(idx)
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