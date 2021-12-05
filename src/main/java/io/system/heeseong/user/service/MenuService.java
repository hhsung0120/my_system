package io.system.heeseong.user.service;

import io.system.heeseong.user.entity.MenuPermissionEntity;
import io.system.heeseong.user.model.Menu;
import io.system.heeseong.user.reposiroty.MenuPermissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                    .filter(list -> "y".equalsIgnoreCase(list.getMenuEntity().getUseYn()))
                    .map(list -> list.entityToValueObject())
                    .collect(toList());
    }

    public void setMenuList() {
//        menuList = menuRepository.findAll()
//                                    .stream()
//                                    .filter(list -> list.getUseYn().equalsIgnoreCase("y"))
//                                    .map(list ->
//                                            Menu.entityToValueObject()
//                                                .idx(list.getIdx())
//                                                .menuUri(list.getMenuUri())
//                                                .menuName(list.getMenuName())
//                                                .description(list.getDescription())
//                                                .useYn(list.getUseYn())
//                                                .orderBy(list.getOrderBy())
//                                                .build()
//                                    ).collect(toList());
    }
}
