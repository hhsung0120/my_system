package io.system.heeseong.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {LoginFailException.class})
    private ResponseEntity<Object> loginFailException(Exception exception) {
        Map<String, Object> result = new HashMap<>();
        result.put("USE", "N");
        result.put("MSG", "잘못된 아이디 또는 패스워드 입니다.");
        return ResponseEntity.ok(result);
    }
}
