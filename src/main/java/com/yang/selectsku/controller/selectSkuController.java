package com.yang.selectsku.controller;

import com.yang.selectsku.DyPost.autoBuyDy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class selectSkuController {
    public getSku getSku;
    public Thread mThread1;

    public getJdSku getJdSku1;
    public Thread jdThread1;
    public getJdSku getJdSku2;
    public Thread jdThread2;

    public analysisKaoLa analysisKaoLa;

    public getKaoLaSku getKaoLaSku;
    public Thread KlThread;


    @RequestMapping("/startSelect")
    public void startSelect(String authorId, String keyWord) {
        autoBuyDy autoBuyDy= new autoBuyDy("服务器提交关键词"+keyWord,authorId,keyWord);

        mThread1 = new Thread(autoBuyDy, "服务器dy关键词");
        mThread1.start();
        System.out.println("开始执行dy关键词轮询抢");

    }

    @RequestMapping("/stopSelect")
    public void stopSelect() {

        mThread1.stop();
        System.out.println("停止dy关键词轮询抢");


    }


//    @RequestMapping("/startSelectJd1")
//    public void startSelectJd1(String itemId,int time,String areaCode){
//        getJdSku1= new getJdSku(itemId,time,areaCode,2);//634411655593
//        jdThread1=new Thread(getJdSku1,"jd线程1");
//        jdThread1.start();
//
//    }
//    @RequestMapping("/stopSelectJd1")
//    public void stopSelectJd1(){
//        System.out.println("停止监控1");
//        jdThread1.stop();
//    }
//    @RequestMapping("/startSelectJd2")
//    public void startSelectJd2(String itemId,int time,String areaCode){
//        getJdSku2= new getJdSku(itemId,time,areaCode,1);//634411655593
//        jdThread2=new Thread(getJdSku2,"jd线程2");
//        jdThread2.start();
//
//    }
//    @RequestMapping("/stopSelectJd2")
//    public void stopSelectJd2(){
//        System.out.println("停止监控2");
//        jdThread2.stop();
//    }

//    @RequestMapping("/JxtKl")
//    public String JxtKl(String JxklGoodId){
//        analysisKaoLa= new analysisKaoLa(JxklGoodId);//634411655593
//        analysisKaoLa.getkaolaInfo(JxklGoodId);
//        String info=analysisKaoLa.stringBuffer.toString();
//        return info;
//    }
//
//
//    @RequestMapping("/startSelectKl")
//    public void startSelectKl(String klGoodId,int klGoodTime,int klGoodIndex){
//        getKaoLaSku= new getKaoLaSku(klGoodId,klGoodTime,klGoodIndex);//634411655593
//        KlThread=new Thread(getKaoLaSku,"kl线程");
//        KlThread.start();
//
//    }
//    @RequestMapping("/stopSelectKl")
//    public void stopSelectKl(){
//        System.out.println("停止考拉监控");
//        KlThread.stop();
//    }

}
