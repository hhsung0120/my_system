package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.TimeEntity;
import io.system.heeseong.common.entity.FileEntity;
import io.system.heeseong.common.enumtype.BoardType;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends TimeEntity {

    @Id @Column(name = "board_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardType boardType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_idx", nullable = false)
    private BoardCategoryEntity boardCategoryEntity;

    @Transient
    private String tableName;

    @Transient
    private List<FileEntity> fileEntityList = new ArrayList<>();

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public BoardEntity() {
    }

    @Builder(builderMethodName = "insertBoard")
    public BoardEntity(Long idx, String tableName, BoardType boardType, String title, String content, Long categoryIdx) {
        this.idx = idx;
        this.tableName = tableName;
        this.boardType = boardType;
        this.title = title;
        this.content = content;
        this.boardCategoryEntity = new BoardCategoryEntity(categoryIdx);
    }

    public void setFileEntityList(List<FileEntity> fileList){
        this.fileEntityList = fileList;
    }

}
