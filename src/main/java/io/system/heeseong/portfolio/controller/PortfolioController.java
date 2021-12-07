package io.system.heeseong.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    @GetMapping("/main")
    public String home(){
        return "/portfolio/list";
    }

    @GetMapping("/form")
    public ModelAndView form(){
        return new ModelAndView("/board/form")
                .addObject("boardType", "portfolio");
    }


}
