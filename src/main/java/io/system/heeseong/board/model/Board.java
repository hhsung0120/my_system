package io.system.heeseong.board.model;

import io.system.heeseong.common.enumtype.BoardType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
public class Board {

    private Long idx;
    private BoardType boardType;
    private int categoryIdx;
    private String title;
    private String content;
    private List<MultipartFile> files;

    public Board() {
    }
}
