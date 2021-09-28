package io.system.heeseong.board.service;

import io.system.heeseong.board.entity.BoardEntity;
import io.system.heeseong.board.model.Board;
import io.system.heeseong.board.repository.BoardDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardDetailService {

    private final BoardDetailRepository boardDetailRepository;


    public Board getBoard(String boardId){
        Optional<BoardEntity> boardEntity = boardDetailRepository.findById(1L);
        log.info("boardId {}", boardEntity.get().getBoardCategoryEntity().getCategoryName());
        log.info("boardId {}", boardEntity.get().getFileEntity().get(0).getOriginalFileName());
        return new Board();
    }
}
