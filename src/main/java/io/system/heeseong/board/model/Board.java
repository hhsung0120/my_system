package io.system.heeseong.board.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Board {
    private Long idx;
    private int categoryIdx;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "Board{" +
                "idx=" + idx +
                ", categoryIdx=" + categoryIdx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Builder
    public Board(Long idx, int categoryIdx, String title, String content) {
        this.idx = idx;
        this.categoryIdx = categoryIdx;
        this.title = title;
        this.content = content;
    }
}
