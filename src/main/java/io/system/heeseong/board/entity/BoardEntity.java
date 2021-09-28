package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.BaseEntity;
import io.system.heeseong.common.entity.FileEntity;
import io.system.heeseong.common.enumtype.BoardType;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends BaseEntity {

    @Id @Column(name = "board_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Transient
    private String tableName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardType boardType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_idx", nullable = false)
    private BoardCategoryEntity boardCategoryEntity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "indexNumber")
    })
    private List<FileEntity> fileEntity;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

}
