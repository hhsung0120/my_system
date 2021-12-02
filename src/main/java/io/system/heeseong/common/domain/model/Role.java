package io.system.heeseong.common.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Role {

    private Long idx;
    private String roleName;
    private String description;
    private String useYn;

    public Role() {
    }

    @Builder(builderMethodName = "entityToValueObject")
    public Role(Long idx, String roleName, String description, String useYn) {
        this.idx = idx;
        this.roleName = roleName;
        this.description = description;
        this.useYn = useYn;
    }
}
