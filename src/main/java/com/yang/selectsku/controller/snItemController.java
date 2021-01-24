package com.yang.selectsku.controller;


import com.yang.selectsku.dao.snItemRepository;
import com.yang.selectsku.dao.snItemScRepository;
import com.yang.selectsku.entity.snItem;
import com.yang.selectsku.entity.snItemSc;
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

    @Autowired
    private snItemScRepository  snItemScRepository;

    @RequestMapping("/snList")
    public String klList(Model model){
        List<snItem> list = new ArrayList<snItem>();
        list = snItemRepository.findAll();
        model.addAttribute("snList",list);
        return "snList";
    }
    @RequestMapping("/snScList")
    public String snScList(Model model){
        List<snItemSc> list = new ArrayList<snItemSc>();
        list = snItemScRepository.findAll();
        model.addAttribute("snList",list);
        return "snScList";
    }


    @RequestMapping("/itemAddSn")
    public String itemAddSn(){
        return "itemAddSn";
    }

    @RequestMapping("/itemAddSnSc")
    public String itemAddSnSc(){
        return "itemAddSnSc";
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

    @RequestMapping("/addSnScItem")
    @ResponseBody
    public String addSnScItem(String firstItemId,String secondItemId,String itemName ,int time){
        snItemSc snItemSc=new snItemSc();
        snItemSc.setFirstItemId(firstItemId);
        snItemSc.setSecondItemId(secondItemId);
        snItemSc.setItemName(itemName);
        snItemSc.setTime(time);
        snItemSc.setStatus(1);

        snItemSc result=snItemScRepository.save(snItemSc);
        new Thread(new getSnSkuBySC(snItemSc.getFirstItemId(),snItemSc.getSecondItemId(), snItemSc.getTime(),snItemSc.getItemName(),true), "snSc" + snItemSc.getId()).start();

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


    @RequestMapping("/removeSnItemSc")
    @ResponseBody
    public String removeSnItemSc(Long itemId){

        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals("snSc"+itemId)){
                lstThreads[i].stop();
            }
        }
        snItemScRepository.deleteById(itemId);
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

    @RequestMapping("/startSnScMonitor")
    @ResponseBody
    public String startSnScMonitor(int byUser){
//        List<Jditem> list=tbItemRepository.findByUserId(byUser);
        List<snItemSc> list=snItemScRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);
        for(int i=0;i<list.size();i++){
            boolean flag=true;
            snItemSc snItemSc=list.get(i);
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("snSc"+snItemSc.getId())){
                    flag=false;
                }
            }
            if(flag) {
                new Thread(new getSnSkuBySC(snItemSc.getFirstItemId(),snItemSc.getSecondItemId(), snItemSc.getTime(),snItemSc.getItemName(),false), "snSc" + snItemSc.getId()).start();
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

    @RequestMapping("/stopSnScMonitor")
    @ResponseBody
    public String stopSnScMonitor(int byUser){
        List<snItemSc> list=snItemScRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for(int i=0;i<list.size();i++){
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("snSc"+list.get(i).getId())){
                    lstThreads[j].stop();
                }
            }
        }

        return "success";
    }
}
