package io.system.heeseong.board.domain.repository;

import io.system.heeseong.board.domain.entity.BoardTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardTypeRepository extends JpaRepository<BoardTypeEntity, Long> {
}
