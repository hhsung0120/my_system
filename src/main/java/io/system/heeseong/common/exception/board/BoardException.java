package io.system.heeseong.common.exception.board;

public class BoardException extends RuntimeException {

    public BoardException() {
    }

    private String message;

    public BoardException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
