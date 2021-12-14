package io.system.heeseong.common.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Validation {

    private Long idx;
    private String check;
    private String use_yn;

    public Validation() {
    }

    public String getKey(){
        return check;
    }

    @Builder(builderMethodName = "entityToValueObject")
    public Validation(Long idx, String check, String use_yn) {
        this.idx = idx;
        this.check = check;
        this.use_yn = use_yn;
    }
}
