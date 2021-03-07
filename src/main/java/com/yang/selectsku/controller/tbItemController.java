package com.yang.selectsku.controller;


import com.yang.selectsku.dao.tbItemRepository;
import com.yang.selectsku.entity.Jditem;
import com.yang.selectsku.entity.tbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class tbItemController {


    @Autowired
    private tbItemRepository tbItemRepository;

    @RequestMapping("/tbList1")
    public String tbList1(Model model){
        List<tbItem> list = new ArrayList<tbItem>();
        list = tbItemRepository.findByUserId(1);
        model.addAttribute("tbList",list);
        return "tbList";
    }
    @RequestMapping("/tbList2")
    public String tbList2(Model model){
        List<tbItem> list = new ArrayList<tbItem>();
        list = tbItemRepository.findByUserId(2);
        model.addAttribute("tbList",list);
        return "tbList2";
    }


    @RequestMapping("/itemAddTb")
    public String itemAddTb(){
        return "itemAddTb";
    }

    @RequestMapping("/itemAddTb2")
    public String itemAddTb2(){
        return "itemAddTb2";
    }

    @RequestMapping("/addTbItem")
    @ResponseBody
    public String addTbItem(String itemId,String itemName ,int time,int byUser){
        tbItem tbItem=new tbItem();
        tbItem.setItemId(itemId);
        tbItem.setItemName(itemName);
        tbItem.setTime(time);
        tbItem.setStatus(1);
        tbItem.setByUser(byUser);

        tbItem result=tbItemRepository.save(tbItem);
        if (byUser==1) {
            new Thread(new getSku(tbItem.getItemId(), tbItem.getTime(),  1, tbItem.getItemName(),true), "tb" + tbItem.getId()).start();
        }else{
            new Thread(new getSku(tbItem.getItemId(), tbItem.getTime(),  2, tbItem.getItemName(),true), "tb" + tbItem.getId()).start();
        }
        return "success";
    }


    @RequestMapping("/removeTbItem")
    @ResponseBody
    public String removeJdItem(Long itemId){

        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals("tb"+itemId)){
                lstThreads[i].stop();
            }
        }
        tbItemRepository.deleteById(itemId);
        return "success";
    }


    @RequestMapping("/startTbMonitor")
    @ResponseBody
    public String startMonitor(int byUser){
//        List<Jditem> list=tbItemRepository.findByUserId(byUser);
        List<tbItem> list=tbItemRepository.findByUserId(byUser);
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);
        for(int i=0;i<list.size();i++){
            boolean flag=true;
            tbItem tbItem=list.get(i);
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("tb"+tbItem.getId())){
                    flag=false;
                }
            }
            if(flag) {
                if (byUser==1) {
                    new Thread(new getSku(tbItem.getItemId(), tbItem.getTime(),  1, tbItem.getItemName(),false), "tb" + tbItem.getId()).start();
                }else{
                    new Thread(new getSku(tbItem.getItemId(), tbItem.getTime(),  2, tbItem.getItemName(),false), "tb" + tbItem.getId()).start();
                }
            }
        }
        return "success";
    }


    @RequestMapping("/stopTbMonitor")
    @ResponseBody
    public String stopMonitor(int byUser){
        List<tbItem> list=tbItemRepository.findByUserId(byUser);
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for(int i=0;i<list.size();i++){
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("tb"+list.get(i).getId())){
                    lstThreads[j].stop();
                }
            }
        }

        return "success";
    }
}
