package io.system.heeseong.common.component;

import io.system.heeseong.board.service.BoardDetailService;
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
    final BoardDetailService boardDetailService;

    @PostConstruct
    public void init() {

        //공통 코드 목록 셋팅
        codeService.setCodeList();

        //어떤 항목들 검사 할건지 셋팅
        validationService.setCheckList();

        //게시판 타입 목록 셋팅
        boardDetailService.getBoardTypeList();

    }
}
