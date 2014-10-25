package com.juseyo.certification.controller;

import com.juseyo.certification.annotation.IgnoreLoginCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @IgnoreLoginCheck
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        if (userSessionApi.isCertificated()) {
//            return "redirect:" + redirectPage("/index.wmp");
//        }
//
//        //Target URL 초기값 세팅 : GOS 시스템은 Client JSON Data 적용.
//        request.setAttribute("targetUrl", "");
//
//        //Target URL
//        loginService.setTargetUrl(request);
        return "/login/login";
    }


    @RequestMapping(value = "/join", method = RequestMethod.GET)
    @IgnoreLoginCheck
    public String join(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/login/join";
    }

}
