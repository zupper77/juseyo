package com.juseyo.notice;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {
    @RequestMapping(value = "/notice/noticeList.*")
    public String boardList(Model model) {
        return "/notice/noticeList";

    }
}
