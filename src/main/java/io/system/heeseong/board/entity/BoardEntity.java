package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.BaseEntity;
import io.system.heeseong.common.enumtype.BoardType;

import javax.persistence.*;

@Entity
@Table(name = "board")
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    private String boardCategory;
    private String boardName;
    private String title;
    private String content;
}
