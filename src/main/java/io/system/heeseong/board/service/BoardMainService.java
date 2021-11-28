package io.system.heeseong.board.service;

import io.system.heeseong.board.model.Board;
import io.system.heeseong.board.repository.BoardRepository;
import io.system.heeseong.common.entity.FileEntity;
import io.system.heeseong.common.model.Files;
import io.system.heeseong.common.repository.FileRepository;
import io.system.heeseong.common.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardMainService {

    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;

    @Value("${path.default-upload-path}")
    private String uploadPath;

    private String tableName = "board";

    @Transactional
    public void saveBoard(Board board){
        if(board.getIdx() == null){
            insertBoard(board);
        }else{

        }
    }

    private void insertBoard(Board board){
        board.setCreateUserAndDate("세션userIdx");


        Long boardIdx = 0L;
        try{
            boardRepository.save(board.toEntity());

//            Long boardIdx = Optional.ofNullable(boardRepository.save(board.toEntity()).getIdx())
//                    .orElseThrow(() -> new RuntimeException("오류"));
        }catch (Exception e){
            e.printStackTrace();
        }


        for(MultipartFile files : board.getFiles()){
            if(!files.isEmpty()){
                Files file = fileUpload(files);
                file.setCreateUser(board.getCreateUserAndDate());
                fileRepository.save(file.toEntity(boardIdx, tableName));
            }
        }
    }

    public Files fileUpload(MultipartFile files){
        return FileUtil.executeFileUpload(files, uploadPath + "/board/");
    }
}
