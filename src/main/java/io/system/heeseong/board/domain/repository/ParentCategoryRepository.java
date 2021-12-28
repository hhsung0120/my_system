package io.system.heeseong.board.domain.repository;

import io.system.heeseong.board.domain.entity.ParentCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentCategoryRepository extends JpaRepository<ParentCategoryEntity, Long> {
    List<ParentCategoryEntity> findAllByUseYn(String flag);
}
