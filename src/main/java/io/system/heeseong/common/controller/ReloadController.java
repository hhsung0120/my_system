package io.system.heeseong.common.controller;

import io.system.heeseong.common.service.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class ReloadController {

    final ValidationService validationService;

    @GetMapping("/validation/reload")
    public Map<String, Object> reloadValidation(){
        validationService.setCheckList();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("data", validationService.getCheckList());
        response.put("isLoginCheck", validationService.isLoginCheck());
        response.put("isMenuPermissionCheck", validationService.isMenuPermissionCheck());

        return response;
    }
}
