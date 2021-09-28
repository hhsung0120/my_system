package io.system.heeseong.board.repository;

import io.system.heeseong.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDetailRepository extends JpaRepository<BoardEntity, Long> {
}
