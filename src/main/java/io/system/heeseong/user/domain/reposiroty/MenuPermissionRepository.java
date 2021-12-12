package io.system.heeseong.user.domain.reposiroty;

import io.system.heeseong.user.domain.entity.MenuPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuPermissionRepository extends JpaRepository<MenuPermissionEntity, Long> {

    List<MenuPermissionEntity> findByRole(String role);
}
