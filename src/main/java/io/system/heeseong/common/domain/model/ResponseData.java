package io.system.heeseong.common.domain.model;

import lombok.Getter;

@Getter
public class ResponseData {

    private String code;
    private String message;
    private Object data;

    public ResponseData() {
    }

    public ResponseData(Code code) {
        setResponseData(code, null);
    }

    public ResponseData(Code code, Object data) {
        setResponseData(code, data);
    }

    private void setResponseData(Code code, Object data){
        this.code = code.getCode();
        this.message = code.getMessage();
        this.data = data;
    }

}
