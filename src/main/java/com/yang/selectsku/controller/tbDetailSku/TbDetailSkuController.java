package com.yang.selectsku.controller.tbDetailSku;

import com.yang.selectsku.controller.getSku;
import com.yang.selectsku.dao.tbDetailItemRepository;
import com.yang.selectsku.entity.tbDetailItem;
import com.yang.selectsku.entity.tbItem;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class TbDetailSkuController {

    @Autowired
    private tbDetailItemRepository tbDetailItemRepository;


    @RequestMapping("/tbDetailList1")
    public String tbDetailList1(Model model){
        List<tbDetailItem> list=tbDetailItemRepository.findByUserId(1);
        model.addAttribute("tbList",list);
        return "tbDetailList1";
    }
    @RequestMapping("/tbDetailList2")
    public String tbDetailList2(Model model){
        List<tbDetailItem> list=tbDetailItemRepository.findByUserId(2);
        model.addAttribute("tbList",list);
        return "tbDetailList2";
    }

    @ResponseBody
    @RequestMapping("/jxTbSku")
    public String jxTbSku(String tbJxItemId){
        tbGetDetailSkuId tbGetDetailSkuId=new tbGetDetailSkuId();
        try {
            tbGetDetailSkuId.tbGetDetailSkuMessage(tbJxItemId);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tbGetDetailSkuId.stringBuffer.toString();
    }

    @RequestMapping("/itemAddTbDetail1")
    public String itemAddTbDetail1(){
        return "itemAddTbDetail1";
    }
    @RequestMapping("/itemAddTbDetail2")
    public String itemAddTbDetail2(){
        return "itemAddTbDetail2";
    }

    @ResponseBody
    @RequestMapping("/addTbDetailItem")
    public String addTbDetailItem(String itemId,String skuId,String itemName ,int time,int byUser){
        tbDetailItem tbDetailItem=new tbDetailItem();
        tbDetailItem.setByUser(byUser);
        tbDetailItem.setItemId(itemId);
        tbDetailItem.setSkuId(skuId);
        tbDetailItem.setTime(time);
        tbDetailItem.setItemName(itemName);
        tbDetailItem.setStatus(1);
        tbDetailItemRepository.save(tbDetailItem);
        if (byUser==1) {
            new Thread(new tbSkuById(tbDetailItem.getItemId(), tbDetailItem.getSkuId(),tbDetailItem.getTime(),  1, tbDetailItem.getItemName(),true), "tbDetail" + tbDetailItem.getId()).start();
        }else{
            new Thread(new tbSkuById(tbDetailItem.getItemId(),tbDetailItem.getSkuId(), tbDetailItem.getTime(),  2, tbDetailItem.getItemName(),true), "tbDetail" + tbDetailItem.getId()).start();
        }
        return "success";
    }

    @RequestMapping("/removeTbDetailItem")
    @ResponseBody
    public String removeTbItem(Long itemId){

        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for (int i = 0; i < noThreads; i++) {
            if (lstThreads[i].getName().equals("tbDetail"+itemId)){
                lstThreads[i].stop();
            }
        }
        tbDetailItemRepository.deleteById(itemId);
        return "success";
    }


    @RequestMapping("/startTbDetailMonitor")
    @ResponseBody
    public String startTbDetailMonitor(int byUser){
        List<tbDetailItem> list=tbDetailItemRepository.findByUserId(byUser);
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);
        for(int i=0;i<list.size();i++){
            boolean flag=true;
            tbDetailItem tbDetailItem=list.get(i);
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("tbDetail"+tbDetailItem.getId())){
                    flag=false;
                }
            }
            if(flag) {
                if (byUser==1) {
                    new Thread(new tbSkuById(tbDetailItem.getItemId(), tbDetailItem.getSkuId(),tbDetailItem.getTime(),  1, tbDetailItem.getItemName(),false), "tbDetail" + tbDetailItem.getId()).start();
                }else{
                    new Thread(new tbSkuById(tbDetailItem.getItemId(),tbDetailItem.getSkuId(), tbDetailItem.getTime(),  2, tbDetailItem.getItemName(),false), "tbDetail" + tbDetailItem.getId()).start();
                }
            }
        }
        return "success";
    }


    @RequestMapping("/stopTbDetailMonitor")
    @ResponseBody
    public String stopTbDetailMonitor(int byUser){
        List<tbDetailItem> list=tbDetailItemRepository.findByUserId(byUser);
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for(int i=0;i<list.size();i++){
            for (int j = 0; j < noThreads; j++) {
                if (lstThreads[j].getName().equals("tbDetail"+list.get(i).getId())){
                    lstThreads[j].stop();
                }
            }
        }

        return "success";
    }


}
