package io.system.heeseong.board.entity;

import io.system.heeseong.board.model.Category;
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
    private String useYn;

    public ParentCategoryEntity() {
    }

    public ParentCategoryEntity(Long idx) {
        this.id = idx;
    }

    public Category toValueObject(){
        return Category.entityToValueObject()
                .idx(id)
                .categoryName(categoryName)
                .build();
    }

}

