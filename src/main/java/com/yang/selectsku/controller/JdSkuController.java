package com.yang.selectsku.controller;

import com.yang.selectsku.dao.JditemRepository;
import com.yang.selectsku.entity.Jditem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JdSkuController {

    @Autowired
    private JditemRepository jditemRepository;


    @RequestMapping("/index2")
    public String index2(){
        return "index2";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/itemAdd")
    public String itemAdd(){
        return "item-add";
    }

    @RequestMapping("/JdList1")
    public String JdList1(Model model){
        List<Jditem> list = new ArrayList<Jditem>();
        list = jditemRepository.findAll();
        model.addAttribute("jdList",list);
        return "JdList1";
    }

    @RequestMapping("/addJdItem")
    @ResponseBody
    public String addJdItem(String itemId,String itemName ,int time){
        Jditem jditem=new Jditem();
        jditem.setItemId(itemId);
        jditem.setItemName(itemName);
        jditem.setTime(time);
        jditem.setStatus(1);
        jditem.setByUser(1);

        Jditem result=jditemRepository.save(jditem);
        return "success";
    }

}
