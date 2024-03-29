package io.system.heeseong.board.domain.model;

import io.system.heeseong.board.domain.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@ToString
public class Board {

    private Long idx;
    private String boardType;
    private Long parentCategoryIdx;
    private Long childCategoryIdx;
    private String title;
    private String content;
    private List<MultipartFile> files;

    @Setter
    private String createUser;

    public Board() {
    }

    @Builder
    public Board(String boardType) {
        this.boardType = boardType;
    }

    public Board(Long idx, String boardType) {
        this.idx = idx;
        this.boardType = boardType;
    }

    public BoardEntity toEntity() {
        return BoardEntity.insertBoard()
                .tableName(boardType)
                .boardType(boardType)
                .parentCategoryIdx(parentCategoryIdx)
                .childCategoryIdx(childCategoryIdx)
                .title(title)
                .content(content)
                .createUser(createUser)
                .build();
    }
}
