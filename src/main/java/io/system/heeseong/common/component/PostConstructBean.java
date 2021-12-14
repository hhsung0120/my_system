package io.system.heeseong.common.component;

import io.system.heeseong.common.service.CodeService;
import io.system.heeseong.common.service.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostConstructBean {

    final CodeService codeService;
    final ValidationService validationService;

    @PostConstruct
    public void init(){
        codeService.setCodeList();
        validationService.setCheckList();
    }
}
