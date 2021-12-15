package io.system.heeseong.common.exception.board;

public class BoardTypeException extends RuntimeException{

    public BoardTypeException(){
    }

    private String message;
    public BoardTypeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
