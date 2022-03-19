package io.system.heeseong.board.service;

import io.system.heeseong.board.domain.entity.BoardTypeEntity;
import io.system.heeseong.board.domain.entity.ChildCategoryEntity;
import io.system.heeseong.board.domain.entity.ParentCategoryEntity;
import io.system.heeseong.board.domain.model.Board;
import io.system.heeseong.board.domain.model.Category;
import io.system.heeseong.board.domain.repository.BoardRepository;
import io.system.heeseong.board.domain.repository.BoardTypeRepository;
import io.system.heeseong.board.domain.repository.ChildCategoryRepository;
import io.system.heeseong.board.domain.repository.ParentCategoryRepository;
import io.system.heeseong.common.domain.repository.FileRepository;
import io.system.heeseong.common.exception.board.BoardTypeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardDetailService {

    List<String> boardTypeList = new ArrayList<>();

    final BoardRepository boardRepository;
    final BoardTypeRepository boardTypeRepository;
    final FileRepository fileRepository;
    final ParentCategoryRepository parentCategoryRepository;
    final ChildCategoryRepository childCategoryRepository;


    public List<Board> getBoardList(String boardType) {
        checkBoardType(boardType);

        return new ArrayList<>();
    }

    private void checkBoardType(String boardType) {
        if (!boardTypeList.contains(boardType)) {
            throw new BoardTypeException();
        }
    }

    public Board getBoard(String boardId) {
//        Optional<BoardEntity> boardEntity = boardRepository.findById(1L);
//        List<FileEntity> fileEntity = fileRepository.findByBoardIdxAndTableName(1L, "BOARD");
//        boardEntity.get().setFileEntityList(fileEntity);
//        log.info("boardId {}", boardEntity.get().getFileEntityList().toArray());
//        for(FileEntity f : boardEntity.get().getFileEntityList()){
//            System.out.println(f.getOriginalFileName());
//        }
        return new Board();
    }

    public List<Category> getParentCategoryList() {
        List<ParentCategoryEntity> parentCategoryEntity =
                Optional.ofNullable(parentCategoryRepository.findAll())
                        .orElse(new ArrayList<>());

        return parentCategoryEntity.stream()
                .map(list -> list.toValueObject())
                .collect(toList());
    }

    public List<Category> getChildCategoryList() {
        List<ChildCategoryEntity> childCategoryEntity =
                Optional.ofNullable(childCategoryRepository.findAllByUseYn("Y"))
                        .orElse(new ArrayList<>());

        return childCategoryEntity.stream()
                .map(list -> list.toValueObject())
                .collect(toList());
    }


    public void getBoardTypeList() {
        List<BoardTypeEntity> boardTypeEntityList =
                Optional.ofNullable(boardTypeRepository.findAll())
                        .orElse(new ArrayList<>());

        for (BoardTypeEntity boardTypeEntity : boardTypeEntityList) {
            if (!boardTypeEntity.isUseYn()) {
                continue;
            }
            boardTypeList.add(boardTypeEntity.getBoardType());
        }
    }
}
