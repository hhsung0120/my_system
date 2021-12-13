package io.system.heeseong.common.exception;

import io.system.heeseong.common.domain.model.ResponseData;
import io.system.heeseong.common.service.CodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private CodeService codeService;

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {LoginFailException.class})
    private ResponseData loginFailException() {
        return new ResponseData(codeService.getCode("login_fail"));
    }
}
