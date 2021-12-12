package io.system.heeseong.common.service;

import io.system.heeseong.common.code.LoginEnum;
import io.system.heeseong.common.domain.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CodeService {

    final CodeRepository codeRepository;

    private Map<String, Object> codeList = new HashMap<>();

    public Map<String, Object> setCodeList(){
        //codeList = codeRepository.findAll().stream()
        codeList.put("login", LoginEnum.class);
        return null;
    }

    public void getCodeList(){
        System.out.println();
    }
}
