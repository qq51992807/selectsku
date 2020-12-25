package com.yang.selectsku.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class selectSkuController {
    public getSku getSku;
    public Thread mThread1;
    @RequestMapping("/startSelect")
    public void startSelect(String itemId,int time){
        getSku= new getSku(itemId,time);//634411655593
        mThread1=new Thread(getSku,"线程1");
        mThread1.start();

    }
    @RequestMapping("/stopSelect")
    public void stopSelect(){
        mThread1.stop();
    }
}
