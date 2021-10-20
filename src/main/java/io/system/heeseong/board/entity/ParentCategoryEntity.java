package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.TimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "parent_category")
public class ParentCategoryEntity extends TimeEntity {

    @Column(name = "parent_category_idx", insertable = false)
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;

    public ParentCategoryEntity() {
    }

    public ParentCategoryEntity(Long idx) {
        this.id = idx;
    }

}

