package com.juseyo.call;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CallController {
    @RequestMapping(value = "/call/callList.*")
    public String callList(Model model) {
        return "/call/callList";
        
    }
}
