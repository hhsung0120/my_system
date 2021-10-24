package io.system.heeseong.board.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Category {

    private Long idx;
    private String categoryName;

    public Category() {
    }

    @Builder(builderMethodName = "entityToValueObject")
    public Category(Long idx, String categoryName) {
        this.idx = idx;
        this.categoryName = categoryName;
    }
}
