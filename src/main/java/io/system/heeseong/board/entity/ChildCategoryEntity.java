package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.TimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "child_category")
public class ChildCategoryEntity extends TimeEntity {

    @Column(name = "child_category_idx")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;

    public ChildCategoryEntity() {
    }

    public ChildCategoryEntity(Long idx) {
        this.id = idx;
    }
}

