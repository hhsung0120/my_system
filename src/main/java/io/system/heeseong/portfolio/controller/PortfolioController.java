package io.system.heeseong.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    @GetMapping
    public String index() {
        return "redirect:/portfolio/main";
    }

    @GetMapping("/main")
    public String main() {
        return "/portfolio/list";
    }

    @GetMapping("/form")
    public ModelAndView form() {
        return new ModelAndView("/board/form")
                .addObject("boardType", "portfolio");
    }


}
