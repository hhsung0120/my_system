package io.system.heeseong.board.model;

import io.system.heeseong.common.code.CommonCode;
import lombok.Getter;

@Getter
public class ResponseData {

    private String code;
    private String message;
    private Object data;

    public ResponseData() {

    }

    public ResponseData(Class commonCode) {
        System.out.println(commonCode.getClass());
        //new ResponseData(commonCode, null);
    }

    public ResponseData(CommonCode commonCode, Object data) {
        this.code = commonCode.getCode();
        this.message = commonCode.getValue();
        this.data = data;
    }
}
