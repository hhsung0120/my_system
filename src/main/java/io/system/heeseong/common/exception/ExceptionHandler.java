package io.system.heeseong.common.exception;

import io.system.heeseong.board.model.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {LoginFailException.class})
    private ResponseData loginFailException() {
        return new ResponseData();
    }
}
