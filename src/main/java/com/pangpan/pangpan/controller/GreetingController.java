package com.pangpan.pangpan.controller;

import com.pangpan.pangpan.mapper.UserMapper;
import com.pangpan.pangpan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request) {

        Cookie[] cookies =  request.getCookies();

//        if(cookies !=null)
//        {
//            for (Cookie cookie : cookies) {
//
//                if(cookie.getName().equals("token"))
//                {
//                    String token = cookie.getValue();
//                    User user =  userMapper.findByToken(token);
//                    if(user != null)
//                    {
//                        request.getSession().setAttribute("user",user);
//                    }
//                    break;
//                }
//            }
//        }
        return "login";
    }

}
