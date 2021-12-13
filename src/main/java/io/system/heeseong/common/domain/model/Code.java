package io.system.heeseong.common.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Code {

    private Long idx;
    private String codeGroup;
    private String code;
    private String message;
    private String useYn;

    public Code() {
    }

    public String getKey(){
        return codeGroup + "_" + code;
    }

    @Builder(builderMethodName = "entityToValueObject")
    public Code(Long idx, String codeGroup, String code, String message, String useYn) {
        this.idx = idx;
        this.codeGroup = codeGroup;
        this.code = code;
        this.message = message;
        this.useYn = useYn;
    }
}
