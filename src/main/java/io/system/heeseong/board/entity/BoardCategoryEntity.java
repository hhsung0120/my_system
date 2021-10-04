package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.TimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "board_category")
public class BoardCategoryEntity extends TimeEntity {

    @Id @Column(name = "category_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String categoryName;

    public BoardCategoryEntity() {
    }

    public BoardCategoryEntity(Long idx) {
        this.idx = idx;
    }

}
