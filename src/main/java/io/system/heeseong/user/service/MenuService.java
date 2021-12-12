package io.system.heeseong.user.service;

import io.system.heeseong.user.domain.entity.MenuPermissionEntity;
import io.system.heeseong.user.domain.model.Menu;
import io.system.heeseong.user.domain.reposiroty.MenuPermissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Log4j2
@Service
@RequiredArgsConstructor
public class MenuService {

    final MenuPermissionRepository menuPermissionRepository;

    public List<Menu> selectMyMenuPermissionList(String role){
        return menuPermissionRepository.findByRole(role)
                .stream()
                    .filter(MenuPermissionEntity::isUseYn)
                    .map(list -> list.entityToValueObject())
                    .sorted(Comparator.comparing(Menu::getOrder))
                    .collect(toList());
    }
}
