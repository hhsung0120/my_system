package io.system.heeseong.user.reposiroty;

import io.system.heeseong.user.entity.MenuPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuPermissionRepository extends JpaRepository<MenuPermissionEntity, Long> {

    List<MenuPermissionEntity> findByRole(String role);
}
