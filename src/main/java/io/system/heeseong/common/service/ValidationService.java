package io.system.heeseong.common.service;

import io.system.heeseong.common.domain.entity.CodeEntity;
import io.system.heeseong.common.domain.entity.ValidationEntity;
import io.system.heeseong.common.domain.model.Code;
import io.system.heeseong.common.domain.model.Validation;
import io.system.heeseong.common.domain.repository.ValidationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ValidationService {

    private Map<String, Validation> checkList = new HashMap<>();

    final ValidationRepository validationRepository;

    public void setCheckList() {
        List<ValidationEntity> validationEntity = Optional.ofNullable(validationRepository.findAll())
                .orElse(new ArrayList<>());

        checkList = validationEntity.stream()
                .filter(list -> "y".equalsIgnoreCase(list.getUse_yn()))
                .map(list -> list.entityToValueObject())
                .collect(Collectors.toMap(Validation::getKey, Function.identity()));
    }

    public Map<String, Validation> getCheckList() {
        return checkList;
    }

    public boolean isLoginCheck() {
        return Optional.ofNullable(checkList.get("login"))
                .isPresent();
    }

    public boolean isMenuPermissionCheck() {
        return Optional.ofNullable(checkList.get("menuPermission"))
                .isPresent();
    }
}
