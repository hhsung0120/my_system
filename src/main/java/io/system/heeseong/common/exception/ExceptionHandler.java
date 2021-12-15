package io.system.heeseong.common.exception;

import io.system.heeseong.common.domain.model.ResponseData;
import io.system.heeseong.common.exception.board.BoardException;
import io.system.heeseong.common.exception.board.BoardTypeException;
import io.system.heeseong.common.exception.login.LoginException;
import io.system.heeseong.common.service.CodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    final CodeService codeService;

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {LoginException.class})
    private ResponseData loginException(Exception e) {
        return new ResponseData(codeService.getCode("login_fail"));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BoardException.class})
    private ResponseData boardException(Exception e) {
        return new ResponseData(codeService.getCode("board_fail"));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BoardTypeException.class})
    private ResponseData boardTypeException(Exception e) {
        return new ResponseData(codeService.getCode("board_type_error"));
    }
}
