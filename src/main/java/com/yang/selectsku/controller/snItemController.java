package com.yang.selectsku.controller;


import com.yang.selectsku.dao.snItemRepository;
import com.yang.selectsku.entity.snItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class snItemController {

    @Autowired
    private snItemRepository snItemRepository;

    @RequestMapping("/snList")
    public String klList(Model model){
        List<snItem> list = new ArrayList<snItem>();
        list = snItemRepository.findAll();
        model.addAttribute("snList",list);
        return "snList";
    }


    @RequestMapping("/itemAddSn")
    public String itemAddSn(){
        return "itemAddSn";
    }

    @RequestMapping("/addSnItem")
    @ResponseBody
    public String addSnItem(String firstItemId,String secondItemId,String itemName ,int time){
        snItem snItem=new snItem();
        snItem.setFirstItemId(firstItemId);
        snItem.setSecondItemId(secondItemId);
        snItem.setItemName(itemName);
        snItem.setTime(time);
        snItem.setStatus(1);

        snItem result=snItemRepository.save(snItem);
        new Thread(new getSnSku(snItem.getFirstItemId(),snItem.getSecondItemId(), snItem.getTime(),snItem.getItemName(),true), "sn" + snItem.getId()).start();

        return "success";
    }


    @RequestMapping("/removeSnItem")
    @ResponseBody
    public String removeSnItem(Long itemId){

        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals("sn"+itemId)){
                lstThreads[i].stop();
            }
        }
        snItemRepository.deleteById(itemId);
        return "success";
    }


    @RequestMapping("/startSnMonitor")
    @ResponseBody
    public String startSnMonitor(int byUser){
//        List<Jditem> list=tbItemRepository.findByUserId(byUser);
        List<snItem> list=snItemRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);
        for(int i=0;i<list.size();i++){
            boolean flag=true;
            snItem snItem=list.get(i);
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("sn"+snItem.getId())){
                    flag=false;
                }
            }
            if(flag) {
                new Thread(new getSnSku(snItem.getFirstItemId(),snItem.getSecondItemId(), snItem.getTime(),snItem.getItemName(),false), "sn" + snItem.getId()).start();
            }
        }
        return "success";
    }


    @RequestMapping("/stopSnMonitor")
    @ResponseBody
    public String stopSnMonitor(int byUser){
        List<snItem> list=snItemRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for(int i=0;i<list.size();i++){
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("sn"+list.get(i).getId())){
                    lstThreads[j].stop();
                }
            }
        }

        return "success";
    }
}
