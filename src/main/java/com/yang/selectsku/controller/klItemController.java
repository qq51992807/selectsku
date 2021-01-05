package com.yang.selectsku.controller;

import com.yang.selectsku.dao.klItemRepository;
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
public class klItemController {

    @Autowired
    private klItemRepository klItemRepository;



    @RequestMapping("/JxtKl")
    @ResponseBody
    public String JxtKl(String JxklGoodId){
        analysisKaoLa analysisKaoLa= new analysisKaoLa(JxklGoodId);//634411655593
        analysisKaoLa.getkaolaInfo(JxklGoodId);
        String info=analysisKaoLa.stringBuffer.toString();
        return info;
    }


    @RequestMapping("/klList")
    public String klList(Model model){
        List<klItem> list = new ArrayList<klItem>();
        list = klItemRepository.findAll();
        model.addAttribute("klList",list);
        return "klList";
    }

    @RequestMapping("/itemAddKl")
    public String itemAddKl(){
        return "itemAddKl";
    }

    @RequestMapping("/addKlItem")
    @ResponseBody
    public String addKlItem(String itemId,String itemName ,int time,int itemIndex,int byUser){
        klItem klItem=new klItem();
        klItem.setItemId(itemId);
        klItem.setItemName(itemName);
        klItem.setTime(time);
        klItem.setStatus(1);
        klItem.setByUser(byUser);
        klItem.setItemIndex(itemIndex);

        klItem result=klItemRepository.save(klItem);
        new Thread(new getKaoLaSku(klItem.getItemId(), klItem.getItemName(),klItem.getTime(),klItem.getItemIndex()), "kl" + klItem.getId()).start();
//        if (byUser==1) {
//            new Thread(new getKaoLaSku(klItem.getItemId(), klItem.getItemName(),klItem.getTime(),klItem.getItemIndex()), "kl" + klItem.getId()).start();
//        }else{
//            new Thread(new getKaoLaSku(klItem.getItemId(), klItem.getItemName(),klItem.getTime(),klItem.getItemIndex()), "kl" + klItem.getId()).start();
//        }
        return "success";
    }

    @RequestMapping("/removeKlItem")
    @ResponseBody
    public String removeKlItem(Long itemId){

        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals("kl"+itemId)){
                lstThreads[i].stop();
            }
        }
        klItemRepository.deleteById(itemId);
        return "success";
    }


    @RequestMapping("/startKlMonitor")
    @ResponseBody
    public String startKlMonitor(int byUser){
//        List<Jditem> list=tbItemRepository.findByUserId(byUser);
        List<klItem> list=klItemRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);
        for(int i=0;i<list.size();i++){
            boolean flag=true;
            klItem klItem=list.get(i);
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("kl"+klItem.getId())){
                    flag=false;
                }
            }
            if(flag) {
//                if (byUser==1) {
//                    new Thread(new getSku(tbItem.getItemId(), tbItem.getTime(),  1, tbItem.getItemName()), "tb" + tbItem.getId()).start();
//                }else{
//                    new Thread(new getSku(tbItem.getItemId(), tbItem.getTime(),  2, tbItem.getItemName()), "tb" + tbItem.getId()).start();
//                }
                new Thread(new getKaoLaSku(klItem.getItemId(), klItem.getItemName(),klItem.getTime(),klItem.getItemIndex()), "kl" + klItem.getId()).start();
            }
        }
        return "success";
    }


    @RequestMapping("/stopKlMonitor")
    @ResponseBody
    public String stopKlMonitor(int byUser){
        List<klItem> list=klItemRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for(int i=0;i<list.size();i++){
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("kl"+list.get(i).getId())){
                    lstThreads[j].stop();
                }
            }
        }

        return "success";
    }

}
