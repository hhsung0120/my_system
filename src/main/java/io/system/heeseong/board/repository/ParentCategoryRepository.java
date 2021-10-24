package io.system.heeseong.board.repository;

import io.system.heeseong.board.entity.ParentCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentCategoryRepository extends JpaRepository<ParentCategoryEntity, Long> {
    List<ParentCategoryEntity> findAllByUseYn(String flag);
}
