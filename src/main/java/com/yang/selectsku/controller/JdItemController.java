package com.yang.selectsku.controller;


import com.yang.selectsku.dao.JditemRepository;
import com.yang.selectsku.entity.Jditem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("jd")
public class JdItemController {

    @Autowired
    private JditemRepository jditemRepository;


    @RequestMapping("/getAllItem")
    @ResponseBody
    public List<Jditem> findAll() {
        List<Jditem> list = new ArrayList<Jditem>();
        list = jditemRepository.findAll();
        return list;
    }





    @RequestMapping("/getByUserName")
    @ResponseBody
    public Jditem getByUserName(String id) {
        Jditem jditem =  jditemRepository.findById(id);
        return jditem;
    }

}
