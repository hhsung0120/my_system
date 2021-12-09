package io.system.heeseong.common.code;

import lombok.Getter;

@Getter
public enum CommonCode {
    SUCCESS("0000", "성공")
    , FAIL("9999", "실패")
    , SERVER_ERROR("500", "서버에러")
    ;

    private String code;
    private String value;

    CommonCode(String code, String value){
        this.code = code;
        this.value = value;
    }

    public String getCode(){
        return code;
    }

    public String getValue(){
        return value;
    }
}

