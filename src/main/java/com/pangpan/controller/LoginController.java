package com.pangpan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password
            , Map<String, Object> map) {
        if (username.equals("admin") && password.equals("123456")) {
            //为了防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        } else {
            map.put("msg","用户名密码错误");
            return "login.html";
        }
    }
}
