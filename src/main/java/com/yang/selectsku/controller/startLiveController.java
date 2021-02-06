package com.yang.selectsku.controller;

import com.yang.selectsku.dao.dyItemRepository;
import com.yang.selectsku.dao.startLiveRepository;
import com.yang.selectsku.entity.dyItem;
import com.yang.selectsku.entity.liveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class startLiveController {

    @Autowired
    private startLiveRepository startLiveRepository;

    @RequestMapping("/dyLiveList")
    public String dyLiveList(Model model){
        List<liveEntity> list = new ArrayList<liveEntity>();
        list = startLiveRepository.findAll();
        model.addAttribute("liveList",list);
        return "dyLiveList";
    }

    @RequestMapping("/addDyLive")
    public String addDyLive(){
        return "addDyLive";
    }

    @RequestMapping("/addDyAuthorLive")
    @ResponseBody
    public String addDyAuthorLive(String authorId,String authorName ,int time){
        liveEntity liveEntity=new liveEntity();
        liveEntity.setAuthorId(authorId);
        liveEntity.setAuthorName(authorName);
        liveEntity.setTime(time);

        liveEntity result=startLiveRepository.save(liveEntity);
        new Thread(new startLive(liveEntity.getAuthorId(),liveEntity.getAuthorName(),liveEntity.getTime(),true), "dyLive" + liveEntity.getId()).start();

        return "success";
    }


    @RequestMapping("/removeDyLive")
    @ResponseBody
    public String removeDyLive(Long itemId){

        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals("dyLive"+itemId)){
                lstThreads[i].stop();
            }
        }
        startLiveRepository.deleteById(itemId);
        return "success";
    }


    @RequestMapping("/startDyLiveMonitor")
    @ResponseBody
    public String startDyLiveMonitor(int byUser){
//        List<Jditem> list=tbItemRepository.findByUserId(byUser);
        List<liveEntity> list=startLiveRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);
        for(int i=0;i<list.size();i++){
            boolean flag=true;
            liveEntity liveEntity=list.get(i);
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("dyList"+liveEntity.getId())){
                    flag=false;
                }
            }
            if(flag) {
                new Thread(new startLive(liveEntity.getAuthorId(),liveEntity.getAuthorName(),liveEntity.getTime(),false), "dyList" + liveEntity.getId()).start();
            }
        }
        return "success";
    }


    @RequestMapping("/stopDyLiveMonitor")
    @ResponseBody
    public String stopDyLiveMonitor(int byUser){
        List<liveEntity> list=startLiveRepository.findAll();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for(int i=0;i<list.size();i++){
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("dyList"+list.get(i).getId())){
                    lstThreads[j].stop();
                }
            }
        }

        return "success";
    }

}
