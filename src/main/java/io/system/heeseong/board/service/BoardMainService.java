package io.system.heeseong.board.service;

import io.system.heeseong.board.model.Board;
import io.system.heeseong.board.repository.BoardRepository;
import io.system.heeseong.common.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardMainService {

    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;

    public void saveBoard(Board board){
        if(board.getIdx() == null){

            if(board.getFiles() != null){
                for(MultipartFile f : board.getFiles()){
                    System.out.println(f.getOriginalFilename());
                }
            }
            System.out.println(board.getCategoryIdx());
            System.out.println(board.getContent());
            //insertBoard(board);
        }else{

        }
    }


    private void insertBoard(Board board){
       // boardRepository.save(board.toEntity());
    }
}
