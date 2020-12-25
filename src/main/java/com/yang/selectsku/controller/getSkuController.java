package com.yang.selectsku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class getSkuController {
    @RequestMapping("/index")
    public String hello(){
        return "index";
    }
}
