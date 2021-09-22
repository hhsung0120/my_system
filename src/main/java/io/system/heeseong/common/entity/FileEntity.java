package io.system.heeseong.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "file")
public class FileEntity extends BaseEntity {

    @Id @Column(name = "file_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String tableName;

    private Long indexNumber; //해당 게시판의 idx

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String extension;
}