package io.system.heeseong.common.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "file")
public class FileEntity extends BaseEntity {

    @Id @Column(name = "file_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String tableName;

    @Column(nullable = false)
    private Long indexNumber; //해당 게시판의 idx

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false)
    private String filePath;
}