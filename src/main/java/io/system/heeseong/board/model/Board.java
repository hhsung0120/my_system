package io.system.heeseong.board.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@ToString
public class Board {
    private Long idx;
    private int categoryIdx;
    private String title;
    private String content;
    private List<MultipartFile> files;

    public Board(Long idx, int categoryIdx, String title, String content, List<MultipartFile> files) {
        this.idx = idx;
        this.categoryIdx = categoryIdx;
        this.title = title;
        this.content = content;
        this.files = files;
    }
}
