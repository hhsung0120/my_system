package io.system.heeseong.common.code;

public enum LoginEnum {
    SUCCESS("0000", "로그인 성공")
    , FAIL("9999", "아이디 또는 비밀번호가 잘못 되었습니다.")
    ;

    private String code;
    private String value;

    LoginEnum(String code, String value){
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
