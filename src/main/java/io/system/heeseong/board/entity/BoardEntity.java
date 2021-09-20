package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.BaseEntity;
import io.system.heeseong.common.enumtype.BoardType;
import io.system.heeseong.common.model.Files;

import javax.persistence.*;

@Entity
@Table(name = "board")
public class BoardEntity extends BaseEntity {

    @Id @Column(name = "board_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    private String boardCategory;
    private String title;
    private String content;

    @JoinColumn(name = "fileIdx", insertable = false, updatable = false)
    private Files file;
}
