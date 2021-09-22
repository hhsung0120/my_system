package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "board_category")
public class BoardCategory extends BaseEntity {

    @Id @Column(name = "category_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String categoryName;
}
