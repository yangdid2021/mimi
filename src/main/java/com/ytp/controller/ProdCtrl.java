package com.ytp.controller;

import com.github.pagehelper.PageInfo;
import com.ytp.pojo.ProductInfo;
import com.ytp.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProdCtrl {
    private static final int PAGE_SIZE = 5;
    @Autowired
    ProdService prod;
    @RequestMapping("/getall.action")
    public String getall(HttpServletRequest request){
        System.out.println("prod1");
        List<ProductInfo> getall = prod.getall();
        System.out.println("prod2");
        System.out.println(getall);
        request.setAttribute("list",getall);
        return "product";

    }
    @RequestMapping("/getpag.action")
    public String getpag(HttpServletRequest request){
        //System.out.println("prod1");
        PageInfo getpag = prod.getpag(1, PAGE_SIZE);
        //System.out.println("prod2");
        request.setAttribute("info",getpag);
        return "product";

    }
    @ResponseBody
    @RequestMapping(value = "/ajaxsplit.action",method = RequestMethod.POST)
    public void ajaxsplit(int page, HttpSession session){
        System.out.println("ajax1");
        PageInfo<ProductInfo> Info=prod.getpag(page,PAGE_SIZE);
        session.setAttribute("info",Info);
        System.out.println("ajax2");
    }
}
