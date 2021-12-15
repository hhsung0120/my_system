package io.system.heeseong.common.code;

public enum TableEnum implements EnumModel{
    BOARD("board")
    ;

    private String value = "";
    TableEnum(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
