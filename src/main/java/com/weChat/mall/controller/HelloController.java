package com.weChat.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author tiny
 * @version 1.0.0
 * @qq 76167050
 *
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "hello";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        String user = request.getRemoteUser();
        if(user != null && !"".equals(user)){
            return "hello";
        }else {
            return "login";
        }
    }

}
