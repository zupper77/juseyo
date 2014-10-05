package com.juseyo.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juseyo.certification.annotation.IgnoreAccessibleCheck;

@Controller
public class BoardController {
    @RequestMapping(value = "/board/boardList.*")
    @IgnoreAccessibleCheck
    public String boardList(Model model) {
        return "/board/boardList";
        
    }
}
