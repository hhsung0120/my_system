package io.system.heeseong.board.controller;

import io.system.heeseong.board.model.Board;
import io.system.heeseong.board.service.BoardDetailService;
import io.system.heeseong.board.service.BoardMainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Paths;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardMainService boardMainService;
    private final BoardDetailService boardDetailService;

    @GetMapping("")
    public String list(){
        return "/board/list";
    }

    @GetMapping("/form")
    public String form(){
        return "/board/form";
    }

    @ResponseBody
    @PostMapping("/form")
    public String save(@ModelAttribute Board board){
        boardMainService.saveBoard(board);
        return "test";
    }

    @GetMapping("/{boardId}")
    public ModelAndView getBoard(@PathVariable String boardId){
        log.info("boardId {}", boardId);
        boardDetailService.getBoard(boardId);
        return new ModelAndView("/board/list");
    }



    @PostMapping("/smartEditorUpload")
    public String smartEditorUpload(StandardMultipartHttpServletRequest request) throws Exception{
        System.out.println(request);

        MultipartFile upload = request.getFile("upload");
        System.out.println(request.getParameter("callback"));
        //유틸 가지고 와서 처리하자
        upload.transferTo(Paths.get("D:/upload/system/"+upload.getOriginalFilename()));
        System.out.println(upload.getOriginalFilename());

        String returnData = new StringBuilder()
                .append(request.getParameter("callback"))
                .append("?callback_func=" + request.getParameter("callback_func"))
                .append("&bNewLine=true&sFileName="+"test.png" + "&sFileURL=" + "/upload/test.png")
                .toString()
                ;

        return "redirect:" + returnData;
    }


}
