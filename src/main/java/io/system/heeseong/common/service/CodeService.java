package io.system.heeseong.common.service;

import io.system.heeseong.common.domain.entity.CodeEntity;
import io.system.heeseong.common.domain.model.Code;
import io.system.heeseong.common.domain.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CodeService {

    private Map<String, Code> codeList = new HashMap<>();

    final CodeRepository codeRepository;

    public void setCodeList(){
        List<CodeEntity> codeEntity = Optional.ofNullable(codeRepository.findAll())
                                                .orElse(new ArrayList<>());

        codeList = codeEntity.stream()
                    .filter(list -> "y".equalsIgnoreCase(list.getUse_yn()))
                    .map(list -> list.entityToValueObject())
                    .collect(Collectors.toMap(Code::getKey, Function.identity()));
    }

    public void getCodeList(){
        log.info("codeList {}", codeList);
    }

    public Code getCode(String key){
        return Optional.ofNullable(codeList.get(key))
                        .orElse(new Code());
    }
}
