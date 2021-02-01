package com.yang.selectsku.controller;

import com.yang.selectsku.utils.RecodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class testController {

    @RequestMapping("reCode")
    @ResponseBody
    public String  reCode(HttpServletResponse response){
           String qrCode= RecodeUtil.creatRrCode("https://m.suning.com/product/0000000000/12133456231.html", 500,500);
//这里去掉https:扫描二维码返回是字符串
        return qrCode;
    }
}
