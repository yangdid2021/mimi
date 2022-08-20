package com.ytp.controller;

import com.ytp.pojo.Admin;
import com.ytp.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAction {


    @Autowired
    Login loginadmin=null;
    @RequestMapping("/login.action")
    public String login(String name, String pwd, HttpServletRequest request){
        System.out.println("起始位置1");

        Admin login = loginadmin.login(name, pwd);
        System.out.println("查询位置2");
        if (login!=null){
            request.setAttribute("admin",login);
            return "main";

        }else {
            request.setAttribute("errmsg","用户名或密码不正确");
            return "login";
        }

    }
}
