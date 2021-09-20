package io.system.heeseong.common.entity;

import javax.persistence.*;

@Entity
public class FileEntity extends BaseEntity {

    @Id @Column(name = "file_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String fileName;
    private String extension;

}
