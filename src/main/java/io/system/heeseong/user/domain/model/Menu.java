package io.system.heeseong.user.domain.model;

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
    private int order;

    public Menu() {
    }

    @Builder(builderMethodName = "entityToValueObject")
    public Menu(Long idx, String menuName, String menuUri, String description, int order) {
        this.idx = idx;
        this.menuName = menuName;
        this.menuUri = menuUri;
        this.description = description;
        this.order = order;
    }
}
