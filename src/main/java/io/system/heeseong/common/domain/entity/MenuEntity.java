package io.system.heeseong.common.domain.entity;

import io.system.heeseong.common.domain.model.Menu;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Entity
@Table(name = "menu")
public class MenuEntity extends TimeEntity {

    @Id @Column(name = "menu_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false)
    private String menuUri;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int orderBy;

    @Column(nullable = false)
    private String useYn;

    public MenuEntity() {
    }

    public Menu entityToValueObject(){
        return Menu.entityToValueObject()
                    .idx(idx)
                    .menuName(menuName)
                    .menuUri(menuUri)
                    .description(description)
                    .orderBy(orderBy)
                    .useYn(useYn)
                    .build();
    }
}