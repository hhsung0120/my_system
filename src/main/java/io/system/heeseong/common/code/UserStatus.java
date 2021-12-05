package io.system.heeseong.common.code;

public enum UserStatus {
    NORMAL("정상")
    , LOCK("잠금")
    , SECESSION("탈퇴")
    ;


    String value = "";
    UserStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
