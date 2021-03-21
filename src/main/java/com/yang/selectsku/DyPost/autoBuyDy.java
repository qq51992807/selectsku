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
        for(int i=0;i<1;i++){
            int num=i+1;
//            List<String> list=new ArrayList<>();
//            list.add("1693828710441007");

            //Nike耐克女子运动鞋DD1503100#NJ002   3470402934024612257 价格699 已售0  dunk蓝色
//         new Thread(new commitDy(itemName,authorId,"3470402934024612257",dyGetCombIdsUtils.getCombIds("3470402934024612257"),false),"抢购线程"+num).start();

 //Nike耐克女子运动鞋DD1503102#NJ004   3470407467488403654 价格699 已售0  dunk冰淇淋
//         new Thread(new commitDy(itemName,authorId,"3470407467488403654",dyGetCombIdsUtils.getCombIds("3470407467488403654"),false),"抢购线程"+num).start();
 //Nike耐克女子运动鞋DD1503102#NJ004   3470407467488403654 价格699 已售0  dunk黑白
//         new Thread(new commitDy(itemName,authorId,"3470407467488403654",dyGetCombIdsUtils.getCombIds("3470407467488403654"),false),"抢购线程"+num).start();
            //Nike耐克运动鞋DD1666100#NJ022   3470437021007352863 价格799 已售0 aj冰淇淋
//         new Thread(new commitDy(itemName,authorId,"3470437021007352863",dyGetCombIdsUtils.getCombIds("3470437021007352863"),false),"抢购线程"+num).start();



         new Thread(new commitDy(itemName,authorId,"3465956964427812126",dyGetCombIdsUtils.getCombIds("3465956964427812126"),false),"抢购线程"+num).start();

//    new Thread(new commitDy(itemName,authorId,"3467328892761730995",dyGetCombIdsUtils.getCombIds("3467328892761730995"),false),"抢购线程"+num).start();



            //测试用
//          new Thread(new commitDy(itemName,authorId,"3466425291780526529",dyGetCombIdsUtils.getCombIds("3466425291780526529"),false),"抢购线程"+num).start();
       }
//        for(int i=0;i<1;i++){
//            new Thread(new autoBuyDy("蓝","70204787595","蓝"),"auto").start();
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
