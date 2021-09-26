package io.system.heeseong.board.controller;

import io.system.heeseong.board.model.Board;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.nio.file.Paths;

@Controller
@RequestMapping("/boards")
public class BoardController {

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
        for(MultipartFile multipartFile : board.getFiles()){
            System.out.println(multipartFile.getOriginalFilename());
        }
        return "test";
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
