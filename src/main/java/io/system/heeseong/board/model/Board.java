package io.system.heeseong.board.model;

import io.system.heeseong.board.entity.BoardEntity;
import io.system.heeseong.common.enumtype.BoardType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@ToString
public class Board {

    private Long idx;
    private BoardType boardType;
    private Long parentCategoryIdx;
    private Long childCategoryIdx;
    private String title;
    private String content;
    private List<MultipartFile> files;

    @Setter
    private String createUser;

    public Board() {
    }

    public Board(Long idx, BoardType boardType) {
        this.idx = idx;
        this.boardType = boardType;
    }

    public BoardEntity toEntity(){
        return BoardEntity.insertBoard()
                .tableName("board")
                .boardType(BoardType.BOARD)
                .parentCategoryIdx(parentCategoryIdx)
                .childCategoryIdx(childCategoryIdx)
                .title(title)
                .content(content)
                .createUser(createUser)
                .build();
    }
}
