package io.system.heeseong.board.domain.entity;

import io.system.heeseong.board.domain.model.Board;
import io.system.heeseong.common.domain.entity.TimeEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "board_type")
public class BoardTypeEntity extends TimeEntity {

    @Id
    @Column(name = "board_type_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String boardType;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String useYn;

    public BoardTypeEntity() {
    }

    public boolean isUseYn() {
        return "y".equalsIgnoreCase(this.getUseYn());
    }

    @Builder
    public Board entityToValueObject() {
        return Board.builder()
                .boardType(this.boardType)
                .build();
    }
}
