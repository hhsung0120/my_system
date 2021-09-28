package io.system.heeseong.common.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Files {

    private Long idx;
    private String uploadPath;
    private String originalFileName;
    private String uuid;
    private String extension;

    public Files() {
    }

    @Builder
    public Files(Long idx, String uploadPath, String originalFileName, String uuid, String extension) {
        this.idx = idx;
        this.uploadPath = uploadPath;
        this.originalFileName = originalFileName;
        this.uuid = uuid;
        this.extension = extension;
    }
}
