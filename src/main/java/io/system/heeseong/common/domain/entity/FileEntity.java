package io.system.heeseong.common.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "file")
public class FileEntity extends TimeEntity {

    @Id @Column(name = "file_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String tableName;

    @Column(nullable = false)
    private Long boardIdx; //해당 게시판의 idx

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private String uploadPath;

    public FileEntity() {
    }

    @Builder(builderMethodName = "fileInsert")
    public FileEntity(String tableName, Long boardIdx, String originalFileName, String uuid, String extension, String uploadPath, Long createUser) {
        super.setCreateUserAndTime(createUser);
        this.tableName = tableName;
        this.boardIdx = boardIdx;
        this.originalFileName = originalFileName;
        this.uuid = uuid;
        this.extension = extension;
        this.uploadPath = uploadPath;
    }
}