package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "board_category")
public class BoardCategoryEntity extends BaseEntity {

    @Id @Column(name = "category_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String categoryName;
}
