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
        list = jditemRepository.findByUserId(1);
        model.addAttribute("jdList",list);
        return "JdList1";
    }

    @RequestMapping("/itemAdd2")
    public String itemAdd2(){
        return "item-add2";
    }

    @RequestMapping("/JdList2")
    public String JdList2(Model model){
        List<Jditem> list = new ArrayList<Jditem>();
        list = jditemRepository.findByUserId(2);
        model.addAttribute("jdList",list);
        return "JdList2";
    }


    @RequestMapping("/addJdItem")
    @ResponseBody
    public String addJdItem(String itemId,String itemName ,int time,int byUser){
        Jditem jditem=new Jditem();
        jditem.setItemId(itemId);
        jditem.setItemName(itemName);
        jditem.setTime(time);
        jditem.setStatus(1);
        jditem.setByUser(byUser);
        Jditem jditem2= new Jditem();
        if(byUser==2) {
            jditem2.setItemId(itemId);
            jditem2.setItemName(itemName);
            jditem2.setTime(time);
            jditem2.setStatus(1);
            jditem2.setByUser(1);
            jditemRepository.save(jditem2);
        }
        Jditem result=jditemRepository.save(jditem);
        if (byUser==1) {
            new Thread(new getJdSku(jditem.getItemId(), jditem.getTime(), "19_1601_50259_51886", 1, jditem.getItemName(),true), "jd" + jditem.getId()).start();
        }else{
            new Thread(new getJdSku(jditem.getItemId(), jditem.getTime(), "22_1930_49324_49398", 2, jditem.getItemName(),true), "jd" + jditem.getId()).start();
            new Thread(new getJdSku(jditem2.getItemId(), jditem2.getTime(), "19_1601_50259_51886", 1, jditem2.getItemName(),true), "jd" + jditem2.getId()).start();
        }
        return "success";
    }

    @RequestMapping("/removeJdItem")
    @ResponseBody
    public String removeJdItem(Long itemId){

        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals("jd"+itemId)){
                lstThreads[i].stop();
            }
        }
        jditemRepository.deleteById(itemId);
        return "success";
    }


    @RequestMapping("/startMonitor")
    @ResponseBody
    public String startMonitor(int byUser){
        List<Jditem> list=jditemRepository.findByUserId(byUser);
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);
        for(int i=0;i<list.size();i++){
            boolean flag=true;
            Jditem jditem=list.get(i);
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("jd"+jditem.getId())){
                    flag=false;
                }
            }
            if(flag) {
                if (byUser==1) {
                    new Thread(new getJdSku(jditem.getItemId(), jditem.getTime(), "19_1601_50259_51886", 1, jditem.getItemName(),false), "jd" + jditem.getId()).start();
                }else{
                    new Thread(new getJdSku(jditem.getItemId(), jditem.getTime(), "22_1930_49324_49398", 2, jditem.getItemName(),false), "jd" + jditem.getId()).start();
                }
            }
        }
        return "success";
    }


    @RequestMapping("/stopMonitor")
    @ResponseBody
    public String stopMonitor(int byUser){
        List<Jditem> list=jditemRepository.findByUserId(byUser);
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for(int i=0;i<list.size();i++){
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("jd"+list.get(i).getId())){
                    lstThreads[j].stop();
                }
            }
        }

        return "success";
    }


}
