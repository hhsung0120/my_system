package io.system.heeseong.common.entity;

import io.system.heeseong.board.entity.BoardEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class FileEntity extends BaseEntity {

    @Id @Column(name = "file_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String tableName;
    private String fileName;
    private String extension;

    @OneToMany(mappedBy = "files")
    private List<BoardEntity> boards;


}