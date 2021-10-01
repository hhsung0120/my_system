package io.system.heeseong.board.service;

import io.system.heeseong.board.entity.BoardEntity;
import io.system.heeseong.board.model.Board;
import io.system.heeseong.board.repository.BoardRepository;
import io.system.heeseong.common.entity.FileEntity;
import io.system.heeseong.common.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardDetailService {

    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;


    public Board getBoard(String boardId){
        Optional<BoardEntity> boardEntity = boardRepository.findById(1L);
        List<FileEntity> fileEntity = fileRepository.findByIndexNumberAndTableName(1L, "BOARD");
        boardEntity.get().setFileEntityList(fileEntity);
        log.info("boardId {}", boardEntity.get().getBoardCategoryEntity().getCategoryName());
        log.info("boardId {}", boardEntity.get().getFileEntityList().toArray());
        for(FileEntity f : boardEntity.get().getFileEntityList()){
            System.out.println(f.getOriginalFileName());
        }
        return new Board();
    }
}
