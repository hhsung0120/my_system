package io.system.heeseong.board.domain.repository;

import io.system.heeseong.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
