package io.system.heeseong.common.domain.repository;

import io.system.heeseong.common.domain.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

}
