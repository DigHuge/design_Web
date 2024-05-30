package com.lzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //控制器
public class HelloController {

    @RequestMapping(value = "/") //处理请求
    public String index(){
        //返回名视图（网页）名称（在xml文件中定义），进行跳转
        return "index";
    }
    @RequestMapping(value = "/target") //处理请求
    public String toTarget(){
        return "target";
    }
}
