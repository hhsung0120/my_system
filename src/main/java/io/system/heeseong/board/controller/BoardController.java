package io.system.heeseong.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
