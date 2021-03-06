package com.yang.selectsku.DyPost;

import com.yang.selectsku.utils.dyGetCombIdsUtils;
import com.yang.selectsku.utils.dyProductSearchUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class autoBuyDy implements Runnable{



    String itemName;
    String authorId;

    String keyWord;

    public autoBuyDy(String itemName,String authorId,String keyWord){
        this.itemName=itemName;
        this.authorId=authorId;
        this.keyWord=keyWord;
    }

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//    String itemName="Mate X2";
    //        String authorId="66916631931";//99514375927
//        String productId="3466033593078445180";
    // List comboIds=dyGetCombIdsUtils.getCombIds("3466425772766549575");
    public static void main(String args[]){
//        autoBuyDy autoBuyDy=new autoBuyDy("鞋子","70204787595","AQ1316003");
//        autoBuyDy autoBuyDy=new autoBuyDy("黄金","2726434986791752","吉祥如意圆形足金");//黄金
//        new Thread(autoBuyDy,"auto").start();
        //罗永浩 4195355415549012
        String itemName="显卡";
        String authorId="110496027780";
        //开启线程提交
        for(int i=0;i<20 ;i++){   int num=i+1;
           //MSI/微星RTX 3060显卡万图师吃鸡电竞游戏台式电脑独立显卡   3467663333451248359 价格9999 已售0
//            new Thread(new commitDy(itemName,authorId,"3467663333451248359",dyGetCombIdsUtils.getCombIds("3467663333451248359"),false),"抢购线程"+num).start();

            List<String> list=new ArrayList<>();
            List<String> list2=new ArrayList<>();
            list.add("1693113852524589");
            list2.add("1693112477830184");

            new Thread(new commitDy(itemName,authorId,"3457099090356261642",dyGetCombIdsUtils.getCombIds("3457099090356261642"),false),"抢购线程"+num).start();
//            new Thread(new commitDy(itemName,authorId,"3467318784547791906",dyGetCombIdsUtils.getCombIds("3467318784547791906"),false),"抢购线程"+num).start();
//            new Thread(new commitDy(itemName,authorId,"3467318460462273917",dyGetCombIdsUtils.getCombIds("3467318460462273917"),false),"抢购线程"+num).start();


            //测试用
//          new Thread(new commitDy(itemName,authorId,"3466425291780526529",dyGetCombIdsUtils.getCombIds("3466425291780526529"),false),"抢购线程"+num).start();
       }
//        for(int i=0;i<1;i++){
//            new Thread(new autoBuyDy("冰淇淋","70204787595","CW7104"),"auto").start();
//            new Thread(new autoBuyDy("魔龙","4441647751118387","魔龙"),"auto").start();
//            new Thread(new autoBuyDy("万图师","4441647751118387","万图师"),"auto").start();
//        }
    }

    @Override
    public void run() {
        boolean flag=true;
        while (flag){
            String productId= dyProductSearchUtils.searchProduct(authorId,keyWord);
            if(productId!=null){
                List combIds= dyGetCombIdsUtils.getCombIds(productId);
                if(flag) {
                    for (int i = 0; i < 7; i++) {
                        int num = i + 1;
                        new Thread(new commitDy(itemName, authorId, productId,combIds,true), "抢购线程" + num).start();
                    }
                }
                flag=false;
            }else {
                System.out.println(df.format(new Date())+"--暂未发现搜索商品-"+keyWord);
            }
        }
    }
}
