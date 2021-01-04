package com.yang.selectsku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class commonController {




    @RequestMapping("/klList")
    public String klList(){
        return "klList";
    }
}
