package com.lzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping("/")
    public String t(){
        return "test";
    }
}
