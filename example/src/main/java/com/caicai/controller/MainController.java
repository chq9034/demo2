package com.caicai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by caihq on 2017/3/6.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/test.do", method = RequestMethod.GET)
    public String index() {
        System.out.println("====================");
        return "/WEB-INF/result.jsp";
    }
}
