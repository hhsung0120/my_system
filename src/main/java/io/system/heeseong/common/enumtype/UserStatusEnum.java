package io.system.heeseong.common.enumtype;

public enum UserStatusEnum implements EnumModel{
    NORMAL("정상")
    , LOCK("잠금")
    , SECESSION("탈퇴")
    ;


    String value = "";
    UserStatusEnum(String value){
        this.value = value;
    }

    @Override
    public String getValue(){
        return value;
    }
}
