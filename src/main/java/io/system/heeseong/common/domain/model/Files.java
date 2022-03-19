package io.system.heeseong.common.domain.model;

import io.system.heeseong.common.domain.entity.FileEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Files {

    private Long idx;
    private String uploadPath;
    private String originalFileName;
    private String uuid;
    private String extension;

    @Setter
    private String createUser;

    public Files() {
    }

    @Builder
    public Files(Long idx, String uploadPath, String originalFileName, String uuid, String extension, String createUser) {
        this.idx = idx;
        this.uploadPath = uploadPath;
        this.originalFileName = originalFileName;
        this.uuid = uuid;
        this.extension = extension;
        this.createUser = createUser;
    }

    public FileEntity toEntity(Long boardIdx, String tableName) {
        return FileEntity.fileInsert()
                .uploadPath(uploadPath)
                .originalFileName(originalFileName)
                .uuid(uuid)
                .extension(extension)
                .boardIdx(boardIdx)
                .tableName(tableName)
                .createUser(createUser)
                .build();
    }
}
