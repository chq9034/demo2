package com.caicai.controller;

import com.caicai.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

/**
 * Created by caihq on 2017/3/6.
 */
@Controller
public class ValidController {

    @RequestMapping(value = "/valid.do", method = RequestMethod.GET)
    public String valid(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getDefaultMessage());
            }
        }
        model.addAttribute("name", user.getUserName());
        return "result";
    }

    /**
     * 返回页面参数1
     * @param user
     * @return
     */
    @RequestMapping(value = "/valid1.do", method = RequestMethod.GET)
    public ModelAndView valid1(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", user.getUserName());
        return new ModelAndView("result", map);
    }

    /**
     * 返回页面参数2
     * @return
     */
    @RequestMapping(value = "/valid2.do", method = RequestMethod.GET)
    public ModelAndView valid2(User user){
        ModelAndView mav=new ModelAndView("result");
        mav.addObject("time", new Date());
        mav.getModel().put("name", user.getUserName());
        return mav;
    }
    /**
     * 返回页面参数3
     * @return
     */
    @RequestMapping(value = "/valid3.do", method = RequestMethod.GET)
    public String valid3(HttpServletRequest request) {
        request.setAttribute("name", request.getParameter("userName"));
        return "result";
    }

}
