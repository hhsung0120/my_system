package io.system.heeseong.common.exception;

public class LoginFailException extends RuntimeException{

    private String message;
    public LoginFailException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public class Message{
        public static final String LOGIN_FAIL_EXCEPTION = "아이디 또는 비밀번호가 잘못 되었습니다.";
    }
}
