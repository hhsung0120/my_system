package io.system.heeseong.board.service;

import io.system.heeseong.board.entity.ChildCategoryEntity;
import io.system.heeseong.board.entity.ParentCategoryEntity;
import io.system.heeseong.board.model.Board;
import io.system.heeseong.board.model.Category;
import io.system.heeseong.board.repository.BoardRepository;
import io.system.heeseong.board.repository.ChildCategoryRepository;
import io.system.heeseong.board.repository.ParentCategoryRepository;
import io.system.heeseong.common.repository.FileRepository;
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

    final BoardRepository boardRepository;
    final FileRepository fileRepository;
    final ParentCategoryRepository parentCategoryRepository;
    final ChildCategoryRepository childCategoryRepository;


    public Board getBoard(String boardId){
//        Optional<BoardEntity> boardEntity = boardRepository.findById(1L);
//        List<FileEntity> fileEntity = fileRepository.findByBoardIdxAndTableName(1L, "BOARD");
//        boardEntity.get().setFileEntityList(fileEntity);
//        log.info("boardId {}", boardEntity.get().getFileEntityList().toArray());
//        for(FileEntity f : boardEntity.get().getFileEntityList()){
//            System.out.println(f.getOriginalFileName());
//        }
        return new Board();
    }

    public List<Category> getParentCategoryList(){
        List<ParentCategoryEntity> parentCategoryEntity =
                Optional.ofNullable(parentCategoryRepository.findAll())
                        .orElse(new ArrayList<>());

        return parentCategoryEntity.stream()
                                    .map( list -> list.toValueObject())
                                    .collect(toList());
    }

    public List<Category> getChildCategoryList(){
        List<ChildCategoryEntity> childCategoryEntity =
                Optional.ofNullable(childCategoryRepository.findAllByUseYn("Y"))
                        .orElse(new ArrayList<>());

        return childCategoryEntity.stream()
                .map( list -> list.toValueObject())
                .collect(toList());
    }


}
