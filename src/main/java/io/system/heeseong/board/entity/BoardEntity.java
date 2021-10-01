package io.system.heeseong.board.entity;

import io.system.heeseong.common.entity.BaseEntity;
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
public class BoardEntity extends BaseEntity {

    @Id @Column(name = "board_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardType boardType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    public void setFileEntityList(List<FileEntity> fileList){
        this.fileEntityList = fileList;
    }

    public BoardEntity() {
    }

}
