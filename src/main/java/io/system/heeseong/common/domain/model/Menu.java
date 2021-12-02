package io.system.heeseong.common.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Menu {

    private Long idx;
    private String menuName;
    private String menuUri;
    private String description;
    private int orderBy;
    private String useYn;

    public Menu() {
    }

    @Builder(builderMethodName = "entityToValueObject")
    public Menu(Long idx, String menuName, String menuUri, String description, int orderBy, String useYn) {
        this.idx = idx;
        this.menuName = menuName;
        this.menuUri = menuUri;
        this.description = description;
        this.orderBy = orderBy;
        this.useYn = useYn;
    }
}
