package io.system.heeseong.board.model;

import lombok.Getter;

@Getter
public class ResponseData {

    private String statusCode;
    private String message;
    private Object data;

    public ResponseData() {
    }

    public ResponseData(String statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }


}
