package io.system.heeseong.board.service;

import io.system.heeseong.board.model.Board;
import io.system.heeseong.board.repository.BoardRepository;
import io.system.heeseong.common.code.TableEnum;
import io.system.heeseong.common.domain.model.Files;
import io.system.heeseong.common.domain.repository.FileRepository;
import io.system.heeseong.common.exception.board.BoardException;
import io.system.heeseong.common.util.FileUtil;
import io.system.heeseong.user.service.AccountUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardMainService {

    final AccountUserService accountUserService;

    final BoardRepository boardRepository;
    final FileRepository fileRepository;

    @Value("${path.default-upload-path}")
    private String uploadPath;

    @Transactional
    public void saveBoard(Board board){
        if(board.getIdx() == null){
            insertBoard(board);
        }else{

        }
    }

    private void insertBoard(Board board){
        board.setCreateUser(accountUserService.getSessionAccountUser().getEmail());

        Long boardIdx = Optional.ofNullable(boardRepository.save(board.toEntity()).getIdx())
                           .orElseThrow(BoardException::new);

        for(MultipartFile files : board.getFiles()){
            if(!files.isEmpty()){
                Files file = fileUpload(files);
                file.setCreateUser(board.getCreateUser());
                fileRepository.save(file.toEntity(boardIdx, TableEnum.BOARD.getValue()));
            }
        }
    }

    public Files fileUpload(MultipartFile files){
        return FileUtil.executeFileUpload(files, uploadPath + "/board/");
    }
}
