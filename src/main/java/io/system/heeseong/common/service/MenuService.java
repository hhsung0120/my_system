package io.system.heeseong.common.service;

import io.system.heeseong.common.domain.entity.MenuEntity;
import io.system.heeseong.common.domain.model.Menu;
import io.system.heeseong.common.domain.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Log4j2
@Service
@RequiredArgsConstructor
public class MenuService {

    final MenuRepository menuRepository;

    private static List<Menu> menuList = new ArrayList<>();

    public void getMenuList(){
         log.info("menuList {}", menuList);
    }

    public void setMenuList() {
        menuList = menuRepository.findAll()
                                    .stream()
                                    .filter(list -> list.getUseYn().equalsIgnoreCase("y"))
                                    .map(list ->
                                            Menu.entityToValueObject()
                                                .idx(list.getIdx())
                                                .menuUri(list.getMenuUri())
                                                .menuName(list.getMenuName())
                                                .description(list.getDescription())
                                                .useYn(list.getUseYn())
                                                .orderBy(list.getOrderBy())
                                                .build()
                                    ).collect(toList());
    }
}
