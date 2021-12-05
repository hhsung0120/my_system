package io.system.heeseong.user.model;

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

    public Menu() {
    }

    @Builder(builderMethodName = "entityToValueObject")
    public Menu(Long idx, String menuName, String menuUri, String description) {
        this.idx = idx;
        this.menuName = menuName;
        this.menuUri = menuUri;
        this.description = description;
    }
}
