package io.system.heeseong.board.controller;

import io.system.heeseong.board.model.Board;
import io.system.heeseong.board.service.BoardDetailService;
import io.system.heeseong.board.service.BoardMainService;
import io.system.heeseong.common.model.Files;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

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
    public String smartEditorUpload(StandardMultipartHttpServletRequest request){
        Files files = boardMainService.fileUpload(request.getFile("upload"));
        String returnData = new StringBuilder()
                .append(request.getParameter("callback"))
                .append("?callback_func=" + request.getParameter("callback_func"))
                .append("&bNewLine=true&sFileName="+ files.getUuid() + "&sFileURL=/upload/board/" + files.getUuid() + "." + files.getExtension())
                .toString();

        return "redirect:" + returnData;
    }


}
