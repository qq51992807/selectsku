package com.yang.selectsku.controller;

import com.yang.selectsku.dao.dyItemRepository;
import com.yang.selectsku.entity.dyItem;
import com.yang.selectsku.entity.klItem;
import com.yang.selectsku.entity.tbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class dyItemController {

    @Autowired
    private dyItemRepository dyItemRepository;

    @RequestMapping("/dyList")
    public String klList(Model model){
        List<dyItem> list = new ArrayList<dyItem>();
        list = dyItemRepository.findAll();
        model.addAttribute("dyList",list);
        return "dyList";
    }


    @RequestMapping("/itemAddDy")
    public String itemAddDy(){
        return "itemAddDy";
    }

    @RequestMapping("/addDyItem")
    @ResponseBody
    public String addTbItem(String itemId,String itemName ,int time){
        dyItem dyItem=new dyItem();
        dyItem.setItemId(itemId);
        dyItem.setItemName(itemName);
        dyItem.setTime(time);
        dyItem.setStatus(1);

        dyItem result=dyItemRepository.save(dyItem);
        new Thread(new getDySku(dyItem.getItemId(),dyItem.getItemName(), dyItem.getTime()), "dy" + dyItem.getId()).start();

        return "success";
    }


    @RequestMapping("/removeDyItem")
    @ResponseBody
    public String removeDyItem(Long itemId){

        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals("dy"+itemId)){
                lstThreads[i].stop();
            }
        }
        dyItemRepository.deleteById(itemId);
        return "success";
    }


    @RequestMapping("/startDyMonitor")
    @ResponseBody
    public String startDyMonitor(int byUser){
//        List<Jditem> list=tbItemRepository.findByUserId(byUser);
        List<dyItem> list=dyItemRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);
        for(int i=0;i<list.size();i++){
            boolean flag=true;
            dyItem dyItem=list.get(i);
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("dy"+dyItem.getId())){
                    flag=false;
                }
            }
            if(flag) {
                new Thread(new getDySku(dyItem.getItemId(),dyItem.getItemName(), dyItem.getTime()), "dy" + dyItem.getId()).start();
            }
        }
        return "success";
    }


    @RequestMapping("/stopDyMonitor")
    @ResponseBody
    public String stopDyMonitor(int byUser){
        List<dyItem> list=dyItemRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for(int i=0;i<list.size();i++){
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("dy"+list.get(i).getId())){
                    lstThreads[j].stop();
                }
            }
        }

        return "success";
    }
}
