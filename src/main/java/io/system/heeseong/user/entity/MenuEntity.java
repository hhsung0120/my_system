package io.system.heeseong.user.entity;

import io.system.heeseong.common.domain.entity.TimeEntity;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

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
    private int order;

    @Column(nullable = false)
    private String listYn;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String useYn;

    public MenuEntity() {
    }

    @Override
    public String toString() {
        return "MenuEntity{" +
                "idx=" + idx +
                ", menuName='" + menuName + '\'' +
                ", menuUri='" + menuUri + '\'' +
                ", order=" + order +
                ", listYn='" + listYn + '\'' +
                ", description='" + description + '\'' +
                ", useYn='" + useYn + '\'' +
                '}';
    }
}