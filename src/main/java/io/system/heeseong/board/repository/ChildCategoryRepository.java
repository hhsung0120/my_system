package io.system.heeseong.board.repository;

import io.system.heeseong.board.entity.ChildCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildCategoryRepository extends JpaRepository<ChildCategoryEntity, Long> {
    List<ChildCategoryEntity> findAllByUseYn(String flag);
}
