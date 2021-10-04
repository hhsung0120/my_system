package io.system.heeseong.board.model;

import io.system.heeseong.board.entity.BoardEntity;
import io.system.heeseong.common.enumtype.BoardType;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@ToString
public class Board {

    private Long idx;
    private Long categoryIdx;
    private BoardType boardType;
    private String title;
    private String content;
    private List<MultipartFile> files;

    public Board() {
    }

    public BoardEntity toEntity(){
        return BoardEntity.insertBoard()
                .tableName("board")
                .boardType(BoardType.BOARD)
                .title(title)
                .content(content)
                .categoryIdx(categoryIdx)
                .build();
    }
}
