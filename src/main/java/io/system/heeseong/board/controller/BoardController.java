package io.system.heeseong.board.controller;

import io.system.heeseong.board.model.Board;
import io.system.heeseong.board.service.BoardDetailService;
import io.system.heeseong.board.service.BoardMainService;
import io.system.heeseong.common.enumtype.BoardType;
import io.system.heeseong.common.model.Files;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(board.toString());
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

    @ResponseBody
    @GetMapping("/test")
    public String test(){
        List<Map<String, Object>> listInMap = new ArrayList<>();
        Map<String, Object> data1 = new HashMap<>();
        data1.put("123", "123");
        data1.put("1234", "123");
        data1.put("1235", "123");

        Map<String, Object> data2 = new HashMap<>();
        data2.put("123", "123");
        data2.put("1234", "123");
        data2.put("1235", "123");

        listInMap.add(data1);
        listInMap.add(data2);

        List<Board> listInBoard = new ArrayList<>();
        Board board = new Board(1L, BoardType.BOARD);
        Board board1 = new Board(1L,BoardType.BOARD);
        Board board2 = new Board(1L, BoardType.BOARD);
        listInBoard.add(board);
        listInBoard.add(board1);
        listInBoard.add(board2);

        Map<String, List<Object>> data = new HashMap<>();
        List<Object> test = new ArrayList<>();
        test.add("1111");
        test.add("11112");
        test.add("11113");

        List<Object> test2 = new ArrayList<>();
        test2.add("1111");
        test2.add("11112");
        test2.add("11113");

        data.put("key1", test);
        data.put("key2", test2);

        Map<String, List<Board>> mpaInList = new HashMap<>();
        mpaInList.put("key1", listInBoard);
        mpaInList.put("key2", listInBoard);



        System.out.println(listInMap);
        System.out.println(listInBoard);
        System.out.println(data);
        System.out.println(mpaInList);


        return "test";
    }



}
